package com.prx.directory.jpa.repository;

import com.prx.directory.jpa.entity.BusinessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository interface for BusinessEntity.
 * This interface extends JpaRepository to provide CRUD operations for BusinessEntity.
 * The primary key type of BusinessEntity is UUID.
 */
public interface BusinessRepository extends JpaRepository<BusinessEntity, UUID> {
}
