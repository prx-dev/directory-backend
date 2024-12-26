package com.prx.directory.api.v1.controller;

import com.prx.directory.api.v1.service.AuthService;
import com.prx.directory.api.v1.to.AuthResponse;
import com.prx.directory.client.to.AuthRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AuthApiControllerTest {

    private final AuthService authService = mock(AuthService.class);
    private final AuthApiController authApiController = new AuthApiController(authService);

    @Test
    @DisplayName("accessToken should return OK status with valid session token and request")
    void accessTokenShouldReturnOkStatusWithValidSessionTokenAndRequest() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setAlias("validAlias");
        AuthResponse authResponse = new AuthResponse("validToken");
        when(authService.validate("validSessionToken")).thenReturn(true);
        when(authService.token(authRequest)).thenReturn(ResponseEntity.ok(authResponse));

        ResponseEntity<AuthResponse> response = authApiController.accessToken("validSessionToken", authRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(authResponse, response.getBody());
    }

    @Test
    @DisplayName("accessToken should return BAD_REQUEST status with invalid session token")
    void accessTokenShouldReturnBadRequestStatusWithInvalidSessionToken() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setAlias("validAlias");
        when(authService.validate("invalidSessionToken")).thenReturn(false);

        ResponseEntity<AuthResponse> response = authApiController.accessToken("invalidSessionToken", authRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    @DisplayName("accessToken should return BAD_REQUEST status with null alias")
    void accessTokenShouldReturnBadRequestStatusWithNullAlias() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setAlias(null);
        when(authService.validate("validSessionToken")).thenReturn(true);
        when(authService.token(authRequest)).thenReturn(ResponseEntity.badRequest().build());

        ResponseEntity<AuthResponse> response = authApiController.accessToken("validSessionToken", authRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    @DisplayName("accessToken should return BAD_REQUEST status with blank alias")
    void accessTokenShouldReturnBadRequestStatusWithBlankAlias() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setAlias("");
        when(authService.validate("validSessionToken")).thenReturn(true);
        when(authService.token(authRequest)).thenReturn(ResponseEntity.badRequest().build());

        ResponseEntity<AuthResponse> response = authApiController.accessToken("validSessionToken", authRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    @DisplayName("accessToken should return NOT_ACCEPTABLE status with blank session token")
    void accessTokenShouldReturnNotAcceptableStatusWithBlankSessionToken() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setAlias("validAlias");
        when(authService.validate("")).thenReturn(false);

        ResponseEntity<AuthResponse> response = authApiController.accessToken("", authRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
