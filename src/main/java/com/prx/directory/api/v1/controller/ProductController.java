package com.prx.directory.api.v1.controller;

import com.prx.directory.api.v1.service.ProductService;
import com.prx.directory.api.v1.to.LinkBusinessProductRequest;
import com.prx.directory.api.v1.to.LinkBusinessProductResponse;
import com.prx.directory.api.v1.to.ProductCreateRequest;
import com.prx.directory.api.v1.to.ProductCreateResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController implements ProductApi {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<ProductCreateResponse> createProduct(@Valid ProductCreateRequest productCreateRequest) {
        return productService.create(productCreateRequest);
    }

    @Override
    public ResponseEntity<LinkBusinessProductResponse> linkProductToBusiness(@Valid LinkBusinessProductRequest businessProductLinkCreateRequest) {
        return productService.linkProductToBusiness(businessProductLinkCreateRequest);
    }
}
