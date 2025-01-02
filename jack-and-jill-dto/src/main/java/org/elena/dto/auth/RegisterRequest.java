package org.elena.dto.auth;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotEmpty @Size(max = 200) @JsonProperty("username") String username,
        @NotEmpty @Size(max = 200) @JsonProperty("password") String password,
        @Nullable @Email @JsonProperty("email") String email,
        @NotNull @JsonProperty("role") UserRole role
) {
}
