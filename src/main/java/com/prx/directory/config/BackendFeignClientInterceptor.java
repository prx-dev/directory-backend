package com.prx.directory.config;

import com.prx.commons.pojo.UserSession;
import com.prx.commons.properties.AuthProperties;
import com.prx.commons.to.TokenResponse;
import feign.RequestInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.UUID;

import static com.prx.commons.constants.keys.ManagementAuthKey.*;
import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static org.springframework.cloud.openfeign.security.OAuth2AccessTokenInterceptor.BEARER;

@Configuration
public class BackendFeignClientInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(BackendFeignClientInterceptor.class);

    @Value("${prx.logging.trace.enabled}")
    private boolean isTraceEnabled;

    private final AuthProperties authProperties;

    public BackendFeignClientInterceptor(AuthProperties authProperties) {
        this.authProperties = authProperties;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            String token;
            try {
                token = getToken();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Add the session-token header to the request
            template.header(AUTHORIZATION, BEARER.concat(" ").concat(token));
            if (isTraceEnabled) {
                LOGGER.info("Headers key/value :::::");
                template.headers().forEach((key, value) ->
                        LOGGER.info("KEY: {}, VALUE: {} :::::", key, value));
            }
        };
    }

    private String getToken() throws Exception {
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        parameters.add(GRANT_TYPE.value, authProperties.getAuthorizationGrantType());
        parameters.add(CLIENT_ID.value, authProperties.getClientId());
        parameters.add(USERNAME.value, authProperties.getUsername());
        parameters.add(PASSWORD.value, authProperties.getPassword());
        parameters.add(CLIENT_SECRET.value, authProperties.getClientSecret());

        var response = client.postForObject(authProperties.getRedirectUri(), new HttpEntity<>(parameters, headers), TokenResponse.class);
        if (Objects.isNull(response)) {
            LOGGER.error("Error occurred while connect with the Manager authenticator");
            throw new Exception("Error occurred while connect with the Manager authenticator");
        }
        return create(response, UUID.randomUUID()).getToken();
    }

    public static UserSession create(TokenResponse tokenResponse, UUID id) {
        UserSession userSession = new UserSession();
        userSession.setId(id);
        userSession.setToken(tokenResponse.getAccessToken());
        return userSession;
    }

}
