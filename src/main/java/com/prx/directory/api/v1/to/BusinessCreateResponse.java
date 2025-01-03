package com.prx.directory.api.v1.to;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prx.commons.util.DateUtil;

import java.time.LocalDateTime;
import java.util.UUID;

public record BusinessCreateResponse(
        UUID id,
        String businessName,
        @JsonFormat(pattern = DateUtil.PATTERN_DATE_TIME_MIL)
        LocalDateTime createdDate,
        @JsonFormat(pattern = DateUtil.PATTERN_DATE_TIME_MIL)
        LocalDateTime updatedDate
) {

    @Override
    public String toString() {
        return "BusinessCreateResponse{" +
                "id=" + id +
                ", businessName='" + businessName + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
