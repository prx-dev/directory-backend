package com.prx.directory.jpa.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProductEntityTest {

    @Test
    void getId() {
        ProductEntity productEntity = new ProductEntity();
        UUID id = UUID.randomUUID();
        productEntity.setId(id);
        assertEquals(id, productEntity.getId());
    }

    @Test
    void getName() {
        ProductEntity productEntity = new ProductEntity();
        String name = "Test Product";
        productEntity.setName(name);
        assertEquals(name, productEntity.getName());
    }

    @Test
    void getDescription() {
        ProductEntity productEntity = new ProductEntity();
        String description = "Test Description";
        productEntity.setDescription(description);
        assertEquals(description, productEntity.getDescription());
    }

    @Test
    void getCreateDate() {
        ProductEntity productEntity = new ProductEntity();
        LocalDate createDate = LocalDate.now();
        productEntity.setCreateDate(createDate);
        assertEquals(createDate, productEntity.getCreateDate());
    }

    @Test
    void getLastDate() {
        ProductEntity productEntity = new ProductEntity();
        LocalDate lastDate = LocalDate.now();
        productEntity.setLastDate(lastDate);
        assertEquals(lastDate, productEntity.getLastDate());
    }

    @Test
    void getActive() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setActive(true);
        assertTrue(productEntity.getActive());
    }

    @Test
    void getCategoryFk() {
        ProductEntity productEntity = new ProductEntity();
        CategoryEntity categoryEntity = new CategoryEntity();
        productEntity.setCategoryFk(categoryEntity);
        assertEquals(categoryEntity, productEntity.getCategoryFk());
    }

}
