package com.prx.directory.api.v1.service;

import com.prx.directory.api.v1.to.BusinessCreateRequest;
import com.prx.directory.api.v1.to.BusinessCreateResponse;
import com.prx.directory.api.v1.to.BusinessTO;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

/// Service interface for business-related operations.
public interface BusinessService {

    /// Creates a new business.
    ///
    /// @param businessCreateRequest the request object containing business details
    /// @return a ResponseEntity containing the response object and HTTP status
    default ResponseEntity<BusinessCreateResponse> create(@NotNull BusinessCreateRequest businessCreateRequest) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    /// Finds a business by its ID.
    ///
    /// @param id the UUID of the business
    /// @return a ResponseEntity containing the business transfer object and HTTP status
    default ResponseEntity<BusinessTO> findById(@NotNull UUID id) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }


}
