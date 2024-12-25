package com.prx.directory.api.v1.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A request object for creating a user.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserCreateRequest(String alias, String password, String email, String firstname, String lastname) {
}
