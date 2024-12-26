package com.prx.directory.api.v1.to;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response object for user creation.
 */
public record UserCreateResponse(
        UUID id, String alias, String email,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime createdDate,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime lastUpdate,
        boolean active,
        UUID personId,
        UUID roleId,
        UUID applicationId) {
}
