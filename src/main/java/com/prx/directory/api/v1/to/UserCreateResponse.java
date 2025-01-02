package com.prx.directory.api.v1.to;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prx.commons.util.DateUtil;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response object for user creation.
 */
public record UserCreateResponse(
        UUID id, String alias, String email,
        @NotNull @JsonFormat(pattern = DateUtil.PATTERN_DATE_TIME_MIL)
        LocalDateTime createdDate,
        @NotNull @JsonFormat(pattern = DateUtil.PATTERN_DATE_TIME_MIL)
        LocalDateTime lastUpdate,
        boolean active,
        UUID personId,
        UUID roleId,
        UUID applicationId) {

        @Override
        public String toString() {
                return "UserCreateResponse{" +
                        "id=" + id +
                        ", alias='" + alias + '\'' +
                        ", email='" + email + '\'' +
                        ", createdDate=" + createdDate +
                        ", lastUpdate=" + lastUpdate +
                        ", active=" + active +
                        ", personId=" + personId +
                        ", roleId=" + roleId +
                        ", applicationId=" + applicationId +
                        '}';
        }
}
