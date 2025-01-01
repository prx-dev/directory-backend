package com.prx.directory.api.v1.to;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public record BusinessCreateResponse(
        UUID id,
        String businessName,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime createdDate,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
