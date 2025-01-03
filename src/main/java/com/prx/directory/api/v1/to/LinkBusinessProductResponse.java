package com.prx.directory.api.v1.to;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prx.commons.util.DateUtil;

import java.time.LocalDateTime;
import java.util.UUID;

public record LinkBusinessProductResponse(
        UUID businessId,
        UUID productId,
        @JsonFormat(pattern = DateUtil.PATTERN_DATE_TIME_MIL)
        LocalDateTime createdAt,
        @JsonFormat(pattern = DateUtil.PATTERN_DATE_TIME_MIL)
        LocalDateTime  lastUpdate,
        Boolean active) {

    @Override
    public String toString() {
        return "BusinessProductLinkCreateResponse{" +
                "businessId=" + businessId +
                ", productId=" + productId +
                ", createdAt=" + createdAt +
                ", lastUpdate=" + lastUpdate +
                ", active=" + active +
                '}';
    }
}
