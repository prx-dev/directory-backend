package com.prx.directory.api.v1.to;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

/// Request object for creating a business.
public record BusinessCreateRequest(
        UUID id,
        @NotNull @NotEmpty
        String name,
        @NotNull
        String description,
        @NotNull @NotEmpty
        UUID categoryId,
        @NotNull @NotEmpty
        UUID userId,
        @NotNull @NotEmpty @Email
        String email,
        String customerServiceEmail,
        String orderManagementEmail,
        String website
) {

    ///  Returns a string representation of the object.
    @Override
    public String toString() {
        return "BusinessCreateRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                ", userId=" + userId +
                ", email='" + email + '\'' +
                ", customerServiceEmail='" + customerServiceEmail + '\'' +
                ", orderManagementEmail='" + orderManagementEmail + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
