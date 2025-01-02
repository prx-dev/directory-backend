package com.prx.directory.api.v1.controller;

import com.prx.directory.api.v1.service.BusinessService;
import com.prx.directory.api.v1.to.BusinessCreateRequest;
import com.prx.directory.api.v1.to.BusinessCreateResponse;
import com.prx.directory.api.v1.to.BusinessTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

/// REST controller for business-related operations.
@Tag(name = "businesses", description = "The Business API")
public interface BusinessApi {

    default BusinessService getService() {
        return new BusinessService() {};
    }

    /// Handles the creation of a new business.
    ///
    /// @param businessCreateRequest the request object containing business details
    /// @return a ResponseEntity containing the response of the business creation operation
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<BusinessCreateResponse> post(@RequestBody BusinessCreateRequest businessCreateRequest) {
        return this.getService().create(businessCreateRequest);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    default ResponseEntity<BusinessTO> findBusiness(@PathVariable UUID id) {
        return this.getService().findById(id);
    }

}
