package com.prx.directory.api.v1.service;

import com.prx.directory.api.v1.to.AuthResponse;
import com.prx.directory.client.BackboneClient;
import com.prx.directory.client.to.AuthRequest;
import com.prx.directory.security.SessionJwtServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service implementation for authentication-related operations.
 */
@Service
public class AuthServiceImpl implements AuthService {

    private final SessionJwtServiceImpl sessionJwtService;
    private final BackboneClient backboneClient;

    /**
     * Constructor for AuthServiceImpl.
     *
     * @param sessionJwtService the service for generating JWT tokens
     * @param backboneClient the client for interacting with the backbone service
     */
    public AuthServiceImpl(SessionJwtServiceImpl sessionJwtService, BackboneClient backboneClient) {
        this.sessionJwtService = sessionJwtService;
        this.backboneClient = backboneClient;
    }

    /**
     * Generates a session token based on the provided authentication request.
     *
     * @param authRequest the authentication request containing user alias
     * @return ResponseEntity containing the authentication response with the session token
     */
    @Override
    public ResponseEntity<AuthResponse> token(AuthRequest authRequest) {
        if (Objects.isNull(authRequest.getAlias()) || authRequest.getAlias().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        var authResponse = new AuthResponse(sessionJwtService.generateSessionToken(authRequest.getAlias(), new ConcurrentHashMap<>()));
        if (Objects.isNull(authResponse) || authResponse.token().isBlank()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        return ResponseEntity.ok(authResponse);
    }

    /**
     * Validates the provided session token using the backbone client.
     *
     * @param sessionTokenBkd the session token to validate
     * @return true if the session token is valid, false otherwise
     */
    @Override
    public boolean validate(String sessionTokenBkd) {
        return backboneClient.validate(sessionTokenBkd);
    }
}
