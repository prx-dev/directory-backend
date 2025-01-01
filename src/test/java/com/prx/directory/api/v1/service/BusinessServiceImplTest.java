package com.prx.directory.api.v1.service;

import com.prx.directory.api.v1.to.BusinessCreateRequest;
import com.prx.directory.api.v1.to.BusinessCreateResponse;
import com.prx.directory.jpa.entity.BusinessEntity;
import com.prx.directory.jpa.entity.CategoryEntity;
import com.prx.directory.jpa.entity.UserEntity;
import com.prx.directory.jpa.repository.BusinessRepository;
import com.prx.directory.mapper.BusinessMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(value = {SpringExtension.class})
class BusinessServiceImplTest {

    @Mock
    private BusinessRepository businessRepository;

    @Mock
    private BusinessMapper businessMapper;

    @InjectMocks
    private BusinessServiceImpl businessService;

    @Test
    @DisplayName("Create business successfully")
    void createBusinessSuccessfully() {
        BusinessCreateRequest request = getBusinessCreateRequest();
        BusinessEntity businessEntity = getBusinessEntity();

        when(businessMapper.toSource(any(BusinessCreateRequest.class))).thenReturn(businessEntity);
        when(businessRepository.save(any(BusinessEntity.class))).thenReturn(businessEntity);
        when(businessMapper.toBusinessCreateResponse(any(BusinessEntity.class)))
                .thenReturn(getBusinessCreateResponse());

        ResponseEntity<BusinessCreateResponse> response = businessService.create(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @DisplayName("Create business with missing fields")
    void createBusinessWithMissingFields() {
        BusinessCreateRequest request = new BusinessCreateRequest(
                null,
                "Example Business",
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        ResponseEntity<BusinessCreateResponse> response = businessService.create(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @DisplayName("Create business with null request")
    void createBusinessWithNullRequest() {
        ResponseEntity<BusinessCreateResponse> response = businessService.create(null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @DisplayName("Create business with duplicate name")
    void createBusinessWithDuplicateName() {
        BusinessCreateRequest request = getBusinessCreateRequest();

        when(businessMapper.toSource(any(BusinessCreateRequest.class))).thenReturn(getBusinessEntity());
        when(businessRepository.save(any(BusinessEntity.class))).thenThrow(new RuntimeException("Duplicate business name"));

        ResponseEntity<BusinessCreateResponse> response = businessService.create(request);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    @DisplayName("Create business with invalid email")
    void createBusinessWithInvalidEmail() {
        BusinessCreateRequest request = new BusinessCreateRequest(
                UUID.randomUUID(),
                "Example Business",
                "This is an example business description.",
                UUID.randomUUID(),
                UUID.randomUUID(),
                "user@##email.ext",
                "user@email.ext",
                "user@$$email.ext",
                "www.example.com"
        );

        ResponseEntity<BusinessCreateResponse> response = businessService.create(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    private static BusinessCreateRequest getBusinessCreateRequest() {
        return new BusinessCreateRequest(
                UUID.randomUUID(),
                "Example Business",
                "This is an example business description.",
                UUID.randomUUID(),
                UUID.randomUUID(),
                "user@email.ext",
                "user@email.ext",
                "user@email.ext",
                "www.example.com"
        );
    }

    private static BusinessCreateResponse getBusinessCreateResponse() {
        return new BusinessCreateResponse(
                UUID.randomUUID(),
                "Example Business",
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    private static BusinessEntity getBusinessEntity() {
        BusinessEntity businessEntity = new BusinessEntity();
        CategoryEntity categoryEntity = new CategoryEntity();
        UserEntity userEntity = new UserEntity();
        categoryEntity.setId(UUID.randomUUID());
        userEntity.setId(UUID.randomUUID());
        businessEntity.setId(UUID.randomUUID());
        businessEntity.setName("Example Business");
        businessEntity.setDescription("This is an example business description.");
        businessEntity.setCategoryFk(categoryEntity);
        businessEntity.setUserFk(userEntity);
        businessEntity.setLastUpdate(LocalDateTime.now());
        businessEntity.setCreatedDate(LocalDateTime.now());

        return businessEntity;
    }
}
