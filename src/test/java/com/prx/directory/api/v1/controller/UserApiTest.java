package com.prx.directory.api.v1.controller;

import com.prx.directory.api.v1.service.UserService;
import com.prx.directory.api.v1.to.UserCreateRequest;
import com.prx.directory.api.v1.to.UserCreateResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(value = {SpringExtension.class})
class UserApiTest {

    private final UserApi userApi = new UserApi() {
        @Override
        public UserService getService() {
            return userService;
        }
    };

    @Mock
    private UserService userService;

    @Test
    @DisplayName("createUser should return OK status with valid request")
    void createUserShouldReturnOkStatusWithValidRequest() {
        UserCreateRequest request = new UserCreateRequest(
                "abc123",
                "user@domain.ext",
                "John",
                "Connor",
                LocalDate.now(),
                "5869995852"
                );
        UserCreateResponse response = new UserCreateResponse(UUID.randomUUID(), "john1", "user@domain.ext", LocalDateTime.now(), LocalDateTime.now(), true, UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID());
        when(userService.create(request)).thenReturn(ResponseEntity.ok(response));

        ResponseEntity<UserCreateResponse> result = userApi.post(request);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(response, result.getBody());
    }

    @Test
    @DisplayName("createUser should return BAD_REQUEST status with null request")
    void createUserShouldReturnBadRequestStatusWithNullRequest() {
        when(userService.create(Mockito.any())).thenReturn(ResponseEntity.badRequest().build());
        ResponseEntity<UserCreateResponse> result = userApi.post(null);

        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    @Test
    @DisplayName("createUser should return BAD_REQUEST status with invalid email")
    void createUserShouldReturnBadRequestStatusWithInvalidEmail() {
        UserCreateRequest request = new UserCreateRequest(
                "abc123",
                "user@domain.ext",
                "John",
                "Connor",
                LocalDate.now(),
                "5869995852"
        );
        when(userService.create(request)).thenReturn(ResponseEntity.badRequest().build());

        ResponseEntity<UserCreateResponse> result = userApi.post(request);

        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    @Test
    @DisplayName("createUser should return CONFLICT status with existing username")
    void createUserShouldReturnConflictStatusWithExistingUsername() {
        UserCreateRequest request = new UserCreateRequest(
                "abc123",
                "user@domain.ext",
                "John",
                "Connor",
                LocalDate.now(),
                "5869995852"
        );
        when(userService.create(request)).thenReturn(ResponseEntity.status(HttpStatus.CONFLICT).build());

        ResponseEntity<UserCreateResponse> result = userApi.post(request);

        assertEquals(HttpStatus.CONFLICT, result.getStatusCode());
    }
}
