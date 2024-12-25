package com.prx.directory.client;

import com.prx.directory.client.to.AuthRequest;
import com.prx.directory.client.to.BackboneUserCreateRequest;
import com.prx.directory.client.to.BackboneUserCreateResponse;
import com.prx.directory.config.BackendFeignClientInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import static com.prx.security.constant.ConstantApp.SESSION_TOKEN_KEY;

@FeignClient(name = "backboneClient", url = "https://prx-qa.backbone.tst/backbone", configuration = BackendFeignClientInterceptor.class)
public interface BackboneClient {

    @GetMapping("/v1/session/validate")
    boolean validate(@RequestHeader(SESSION_TOKEN_KEY) String sessionToken);

    @PostMapping("/v1/session")
    String token(AuthRequest authRequest);

    @PostMapping("/v1/users")
    BackboneUserCreateResponse post(BackboneUserCreateRequest backboneUserCreateRequest);
}
