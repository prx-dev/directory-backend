package com.prx.directory.config.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Configuration interface for MapStruct mappers.
 * This interface configures the MapStruct mappers with specific settings.
 */
@MapperConfig(
        // Specifies that the mapper should be a Spring bean.
        componentModel = MappingConstants.ComponentModel.SPRING,
        // Specifies that properties with null values should not be mapped.
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        // Specifies that the mapper should fail if there are any unmapped properties.
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        // Specifies that the mapper should fail if there are any unmapped properties.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface MapperAppConfig {
}
