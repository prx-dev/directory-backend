package com.prx.directory.mapper;

import com.prx.directory.api.v1.to.BusinessCreateRequest;
import com.prx.directory.api.v1.to.BusinessCreateResponse;
import com.prx.directory.api.v1.to.BusinessTO;
import com.prx.directory.config.mapper.MapperAppConfig;
import com.prx.directory.jpa.entity.BusinessEntity;
import com.prx.directory.jpa.entity.CategoryEntity;
import com.prx.directory.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

/// Mapper for the entity {@link BusinessEntity} and its DTO {@link BusinessCreateRequest} and {@link BusinessCreateResponse}.
/// This interface extends JpaRepository to provide CRUD operations for BusinessEntity.
@Mapper(
        // Specifies that the mapper should be a Spring bean.
        uses = {BusinessEntity.class, BusinessCreateRequest.class, BusinessCreateResponse.class},
        // Specifies the configuration class to use for this mapper.
        config = MapperAppConfig.class
)
public interface BusinessMapper {

    /// Converts a BusinessCreateRequest object to a BusinessEntity object.
    ///
    /// @param businessCreateRequest The BusinessCreateRequest object to convert.
    /// @return The converted BusinessEntity object.
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "createdDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "lastUpdate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "userFk", expression = "java(getUser(businessCreateRequest.userId()))")
    @Mapping(target = "categoryFk", expression = "java(getCategory(businessCreateRequest.categoryId()))")
    BusinessEntity toSource(BusinessCreateRequest businessCreateRequest);

    /// Converts a BusinessEntity object to a BusinessCreateResponse object.
    ///
    /// @param businessEntity The BusinessEntity object to convert.
    /// @return The converted BusinessCreateResponse object.
    @Mapping(target = "id", source = "id")
    @Mapping(target = "businessName", source = "name")
    @Mapping(target = "createdDate", source = "createdDate")
    @Mapping(target = "updatedDate", source = "lastUpdate")
    BusinessCreateResponse toBusinessCreateResponse(BusinessEntity businessEntity);

    /// The method maps the fields of the BusinessEntity object to the fields of the BusinessTO object.
    ///
    /// @param businessEntity The BusinessEntity object to convert.
    /// @return The converted BusinessTO object.
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "customerServiceEmail", ignore = true)
    @Mapping(target = "orderManagementEmail", ignore = true)
    @Mapping(target = "userId", source = "businessEntity.userFk.id")
    @Mapping(target = "categoryId", source = "businessEntity.categoryFk.id")
    @Mapping(target = "createdDate", source = "createdDate")
    @Mapping(target = "updatedDate", source = "lastUpdate")
    BusinessTO toBusinessTO(BusinessEntity businessEntity);

    /// Converts a BusinessEntity object to a BusinessCreateResponse object.
    ///
    /// @param userId The BusinessEntity object to convert.
    /// @return The converted BusinessCreateResponse object.
    default UserEntity getUser(UUID userId){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        return userEntity;
    }

    /// Converts a BusinessEntity object to a BusinessCreateResponse object.
    ///
    /// @param categoryId The BusinessEntity object to convert.
    /// @return The converted BusinessCreateResponse object.
    default CategoryEntity getCategory(UUID categoryId){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(categoryId);
        return categoryEntity;
    }

}
