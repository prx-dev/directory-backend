package com.prx.directory.jpa.repository;

import com.prx.directory.jpa.entity.BusinessProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusinessProductRepository extends JpaRepository<BusinessProductEntity, UUID> {

}
