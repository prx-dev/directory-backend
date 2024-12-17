package com.prx.directory.api.v1.service;

import com.prx.directory.api.v1.to.UserCreateRequest;
import com.prx.directory.api.v1.to.UserCreateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Service interface for user-related operations.
 */
public interface UserService {


/**
     * Creates a new user.
     *
     * @param userCreateRequest the request object containing user details
     * @return a ResponseEntity containing the response object and HTTP status
     */
    default ResponseEntity<UserCreateResponse> create(@RequestBody UserCreateRequest userCreateRequest) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
