package com.prx.directory.jpa.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BusinessProductEntityIdTest {

    @Test
    @DisplayName("Create BusinessProductEntityId successfully")
    void createBusinessProductEntityIdSuccessfully() {
        UUID businessId = UUID.randomUUID();
        UUID productId = UUID.randomUUID();
        BusinessProductEntityId entityId = new BusinessProductEntityId(businessId, productId);

        assertEquals(businessId, entityId.getBusinessId());
        assertEquals(productId, entityId.getProductId());
    }

    @Test
    @DisplayName("BusinessProductEntityId equality")
    void businessProductEntityIdEquality() {
        UUID businessId = UUID.randomUUID();
        UUID productId = UUID.randomUUID();
        BusinessProductEntityId entityId1 = new BusinessProductEntityId(businessId, productId);
        BusinessProductEntityId entityId2 = new BusinessProductEntityId(businessId, productId);

        assertEquals(entityId1, entityId2);
        assertEquals(entityId1.hashCode(), entityId2.hashCode());
    }

    @Test
    @DisplayName("BusinessProductEntityId inequality")
    void businessProductEntityIdInequality() {
        UUID businessId1 = UUID.randomUUID();
        UUID productId1 = UUID.randomUUID();
        UUID businessId2 = UUID.randomUUID();
        UUID productId2 = UUID.randomUUID();
        BusinessProductEntityId entityId1 = new BusinessProductEntityId(businessId1, productId1);
        BusinessProductEntityId entityId2 = new BusinessProductEntityId(businessId2, productId2);

        assertNotEquals(entityId1, entityId2);
        assertNotEquals(entityId1.hashCode(), entityId2.hashCode());
    }

    @Test
    @DisplayName("Set businessId successfully")
    void setBusinessIdSuccessfully() {
        UUID businessId = UUID.randomUUID();
        UUID productId = UUID.randomUUID();
        BusinessProductEntityId entityId = new BusinessProductEntityId();
        entityId.setBusinessId(businessId);
        entityId.setProductId(productId);

        assertEquals(businessId, entityId.getBusinessId());
        assertEquals(productId, entityId.getProductId());
    }

    @Test
    @DisplayName("Set productId successfully")
    void setProductIdSuccessfully() {
        UUID businessId = UUID.randomUUID();
        UUID productId = UUID.randomUUID();
        BusinessProductEntityId entityId = new BusinessProductEntityId();
        entityId.setBusinessId(businessId);
        entityId.setProductId(productId);

        assertEquals(businessId, entityId.getBusinessId());
        assertEquals(productId, entityId.getProductId());
    }

    @Test
    @DisplayName("BusinessProductEntityId equals method alternative way")
    void businessProductEntityIdEqualsAlternative() {
        UUID businessId = UUID.randomUUID();
        UUID productId = UUID.randomUUID();
        BusinessProductEntityId entityId1 = new BusinessProductEntityId(businessId, productId);
        BusinessProductEntityId entityId2 = new BusinessProductEntityId(businessId, productId);

        assertEquals(entityId1, entityId2);
        assertEquals(entityId1.hashCode(), entityId2.hashCode());
    }

    @Test
    @DisplayName("BusinessProductEntityId not equals method alternative way")
    void businessProductEntityIdNotEqualsAlternative() {
        UUID businessId1 = UUID.randomUUID();
        UUID productId1 = UUID.randomUUID();
        UUID businessId2 = UUID.randomUUID();
        UUID productId2 = UUID.randomUUID();
        BusinessProductEntityId entityId1 = new BusinessProductEntityId(businessId1, productId1);
        BusinessProductEntityId entityId2 = new BusinessProductEntityId(businessId2, productId2);

        assertNotEquals(entityId1, entityId2);
        assertNotEquals(entityId1.hashCode(), entityId2.hashCode());
    }


}
