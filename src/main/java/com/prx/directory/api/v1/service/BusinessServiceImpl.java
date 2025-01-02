package com.prx.directory.api.v1.service;

import com.prx.directory.api.v1.to.BusinessCreateRequest;
import com.prx.directory.api.v1.to.BusinessCreateResponse;
import com.prx.directory.api.v1.to.BusinessTO;
import com.prx.directory.jpa.repository.BusinessRepository;
import com.prx.directory.mapper.BusinessMapper;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

/// Service implementation for business-related operations.
@Service
public class BusinessServiceImpl implements BusinessService {

    private final BusinessRepository businessRepository;
    private final BusinessMapper businessMapper;

    /// Constructs a new BusinessServiceImpl with the specified BusinessRepository and BusinessMapper.
    ///
    /// @param businessRepository the repository used to access business data
    /// @param businessMapper     the mapper used to convert between business-related objects
    public BusinessServiceImpl(BusinessRepository businessRepository, BusinessMapper businessMapper) {
        this.businessRepository = businessRepository;
        this.businessMapper = businessMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<BusinessCreateResponse> create(BusinessCreateRequest businessCreateRequest) {
        // TODO - Add step to validate the business name is not already in use
        // TODO - Set a limit on the number of businesses a user can create along with a plan
        try {
            var business = businessMapper.toSource(businessCreateRequest);
            var savedBusiness = businessRepository.save(business);
            return ResponseEntity.ok(businessMapper.toBusinessCreateResponse(savedBusiness));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<BusinessTO> findById(@NotNull UUID id) {
        var business = businessRepository.findById(id);
        return business.map(businessEntity ->
                        ResponseEntity.ok(businessMapper.toBusinessTO(businessEntity)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
