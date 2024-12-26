package com.prx.directory.api.v1.controller;

import com.prx.directory.api.v1.service.AuthService;
import com.prx.directory.api.v1.to.AuthResponse;
import com.prx.directory.client.to.AuthRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@Tag(name = "auth", description = "The authenticate API")
public interface AuthAPi {
     String BACKBONE_SESSION_TOKEN = "session-token-bkd";
    default AuthService getService() {
        return new AuthService() {
        };
    }

    @PostMapping(path = "/token", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<AuthResponse> accessToken(@RequestHeader(BACKBONE_SESSION_TOKEN) String sessionTokenBkd, @RequestBody AuthRequest authRequest) {
        return this.getService().token(authRequest);
    }

}
