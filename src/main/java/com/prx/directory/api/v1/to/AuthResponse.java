package com.prx.directory.api.v1.to;

import jakarta.validation.constraints.NotBlank;

public record AuthResponse(
        @NotBlank
        String token) {
}
