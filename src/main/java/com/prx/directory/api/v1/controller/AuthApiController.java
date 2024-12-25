package com.prx.directory.api.v1.controller;

import com.prx.directory.api.v1.service.AuthService;
import com.prx.directory.api.v1.to.AuthResponse;
import com.prx.directory.client.to.AuthRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthApiController implements AuthAPi {

    private final AuthService authService;

    public AuthApiController(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<AuthResponse> accessToken(String sessionTokenBkd, AuthRequest authRequest) {
        boolean isValid = authService.validate(sessionTokenBkd);
        if(isValid){
            return authService.token(authRequest);
        }
        return ResponseEntity.badRequest().build();
    }
}
