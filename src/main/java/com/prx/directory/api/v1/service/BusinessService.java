package com.prx.directory.api.v1.service;

import com.prx.directory.api.v1.to.BusinessCreateRequest;
import com.prx.directory.api.v1.to.BusinessCreateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/// Service interface for business-related operations.
public interface BusinessService {

    /// Creates a new business.
    ///
    /// @param businessCreateRequest the request object containing business details
    /// @return a ResponseEntity containing the response object and HTTP status
    default ResponseEntity<BusinessCreateResponse> create(BusinessCreateRequest businessCreateRequest) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
