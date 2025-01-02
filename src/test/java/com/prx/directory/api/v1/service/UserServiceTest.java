package com.prx.directory.api.v1.service;

import com.prx.directory.api.v1.to.UserCreateRequest;
import com.prx.directory.api.v1.to.UserCreateResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {

    private final UserService userService = new UserService() {};

    @Test
    @DisplayName("Create User Successfully")
    void createUserSuccessfully() {
        UserCreateRequest request = new UserCreateRequest(
                "abc123",
                "user@domain.ext",
                "John",
                "Connor",
                LocalDate.now(),
                "5869995852"
        );
        // Set necessary fields for request
        ResponseEntity<UserCreateResponse> response = userService.create(request);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, response.getStatusCode());
    }

    @Test
    @DisplayName("Create User with Null Request")
    void createUserWithNullRequest() {
        ResponseEntity<UserCreateResponse> response = userService.create(null);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, response.getStatusCode());
    }
}
