package com.prx.directory.api.v1.service;

import com.prx.directory.api.v1.to.UserCreateRequest;
import com.prx.directory.api.v1.to.UserCreateResponse;
import com.prx.directory.client.BackboneClient;
import com.prx.directory.mapper.UserCreateMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

/// Service implementation for user-related operations.
@Service
public class UserServiceImpl implements UserService {

    @Value("${prx.directory.application-id}")
    private String applicationId;
    @Value("${prx.directory.role-id}")
    private String initialRoleId;

    private final BackboneClient backboneClient;
    private final UserCreateMapper userCreateMapper;

    /// Constructs a new UserServiceImpl with the specified BackboneClient and UserCreateMapper.
    ///
    /// @param backboneClient the client used to communicate with the backend
    /// @param userCreateMapper the mapper used to convert between request/response objects and backend objects
    public UserServiceImpl(BackboneClient backboneClient, UserCreateMapper userCreateMapper) {
        this.backboneClient = backboneClient;
        this.userCreateMapper = userCreateMapper;
    }

    /// Creates a new user based on the provided UserCreateRequest.
    ///
    /// @param userCreateRequest the request object containing user details
    /// @return a ResponseEntity containing the UserCreateResponse
    @Override
    public ResponseEntity<UserCreateResponse> create(UserCreateRequest userCreateRequest) {
        try {
            if(Objects.isNull(userCreateRequest)) {
                return ResponseEntity.status(BAD_REQUEST).header("message-error", "Null content invalid").build();
            }
            var backboneUserCreateRequest = userCreateMapper.toBackbone(userCreateRequest, UUID.fromString(applicationId), UUID.fromString(initialRoleId));
            var userCreateResponse = userCreateMapper.fromBackbone(backboneClient.post(backboneUserCreateRequest));
            return ResponseEntity.ok(userCreateResponse);
        } catch (RuntimeException e) {
            if(e.getMessage().contains("Username already exists")) {
                return ResponseEntity.status(CONFLICT).header("message-error", e.getMessage()).build();
            }
            return ResponseEntity.status(BAD_REQUEST).header("message-error", e.getMessage()).build();
        }
    }
}
