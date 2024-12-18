package com.prx.directory.jpa.repository;

import com.prx.directory.jpa.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository interface for accessing CategoryEntity data.
 * This interface extends JpaRepository to provide CRUD operations for CategoryEntity.
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {
}
