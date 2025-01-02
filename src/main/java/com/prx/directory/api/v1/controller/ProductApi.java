package com.prx.directory.api.v1.controller;

import com.prx.directory.api.v1.service.ProductService;
import com.prx.directory.api.v1.to.LinkBusinessProductRequest;
import com.prx.directory.api.v1.to.LinkBusinessProductResponse;
import com.prx.directory.api.v1.to.ProductCreateRequest;
import com.prx.directory.api.v1.to.ProductCreateResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "products", description = "The Product API")
public interface ProductApi {

    default ProductService getProductService() {
        // Default implementation could be overridden by the controller
        return new ProductService(){};
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<ProductCreateResponse> createProduct(@RequestBody ProductCreateRequest productCreateRequest) {
        // Default implementation could be overridden by the controller
        return getProductService().create(productCreateRequest);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path = "/link")
    default ResponseEntity<LinkBusinessProductResponse> linkProductToBusiness(@RequestBody LinkBusinessProductRequest businessProductLinkCreateRequest) {
        // Default implementation could be overridden by the controller
        return getProductService().linkProductToBusiness(businessProductLinkCreateRequest);
    }
}
