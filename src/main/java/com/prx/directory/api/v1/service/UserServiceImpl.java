package com.prx.directory.api.v1.service;

import com.prx.directory.api.v1.to.UserCreateRequest;
import com.prx.directory.api.v1.to.UserCreateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        // Default constructor
    }

    @Override
    public ResponseEntity<UserCreateResponse> create(UserCreateRequest userCreateRequest) {
        return ResponseEntity.ok(new UserCreateResponse("Hola!!!"));
    }
}
