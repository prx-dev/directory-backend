package com.prx.directory.api.v1.controller;

import com.prx.directory.api.v1.service.AuthService;
import com.prx.directory.api.v1.to.AuthResponse;
import com.prx.directory.client.to.AuthRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AuthAPiTest {

    private final AuthService authService = mock(AuthService.class);
    private final AuthAPi authAPi = new AuthAPi() {
        @Override
        public AuthService getService() {
            return authService;
        }
    };

    @Test
    @DisplayName("accessToken should return OK status with valid request")
    void accessTokenShouldReturnOkStatusWithValidRequest() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setAlias("validAlias");
        AuthResponse authResponse = new AuthResponse("validToken");
        when(authService.token(authRequest)).thenReturn(ResponseEntity.ok(authResponse));

        ResponseEntity<AuthResponse> response = authAPi.accessToken("validSessionToken", authRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(authResponse, response.getBody());
    }

    @Test
    @DisplayName("accessToken should return BAD_REQUEST status with null alias")
    void accessTokenShouldReturnBadRequestStatusWithNullAlias() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setAlias(null);
        when(authService.token(authRequest)).thenReturn(ResponseEntity.badRequest().build());

        ResponseEntity<AuthResponse> response = authAPi.accessToken("validSessionToken", authRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    @DisplayName("accessToken should return BAD_REQUEST status with blank alias")
    void accessTokenShouldReturnBadRequestStatusWithBlankAlias() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setAlias("");
        when(authService.token(authRequest)).thenReturn(ResponseEntity.badRequest().build());

        ResponseEntity<AuthResponse> response = authAPi.accessToken("validSessionToken", authRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    @DisplayName("accessToken should return NOT_ACCEPTABLE status with blank token")
    void accessTokenShouldReturnNotAcceptableStatusWithBlankToken() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setAlias("validAlias");
        when(authService.token(authRequest)).thenReturn(ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build());

        ResponseEntity<AuthResponse> response = authAPi.accessToken("", authRequest);

        assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());
    }
}
