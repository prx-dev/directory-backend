package com.prx.directory.api.v1.service;

import com.prx.directory.api.v1.to.LinkBusinessProductRequest;
import com.prx.directory.api.v1.to.LinkBusinessProductResponse;
import com.prx.directory.api.v1.to.ProductCreateRequest;
import com.prx.directory.api.v1.to.ProductCreateResponse;
import com.prx.directory.jpa.repository.BusinessProductRepository;
import com.prx.directory.jpa.repository.ProductRepository;
import com.prx.directory.mapper.BusinessProductMapper;
import com.prx.directory.mapper.ProductMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BusinessProductRepository businessProductRepository;
    private final ProductMapper productMapper;
    private final BusinessProductMapper businessProductMapper;

    public ProductServiceImpl(ProductRepository productRepository, BusinessProductRepository businessProductRepository, ProductMapper productMapper, BusinessProductMapper businessProductMapper) {
        this.productRepository = productRepository;
        this.businessProductRepository = businessProductRepository;
        this.productMapper = productMapper;
        this.businessProductMapper = businessProductMapper;
    }

    @Override
    public ResponseEntity<ProductCreateResponse> create(@Valid ProductCreateRequest productCreateRequest) {
        if(Objects.isNull(productCreateRequest)) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(
                productMapper.toProductCreateResponse(productRepository
                        .save(productMapper.toProductEntity(productCreateRequest))),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<LinkBusinessProductResponse> linkProductToBusiness(LinkBusinessProductRequest businessProductLinkCreateRequest) {
        if(Objects.isNull(businessProductLinkCreateRequest)) {
            return ResponseEntity.badRequest().build();
        }
        var businessProductEntityResult = businessProductRepository.save(businessProductMapper.toSource(businessProductLinkCreateRequest));
        if(Objects.isNull(businessProductEntityResult.getId())) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(
                businessProductMapper.toLinkBusinessProductResponse(businessProductEntityResult),
                HttpStatus.CREATED);
    }
}
