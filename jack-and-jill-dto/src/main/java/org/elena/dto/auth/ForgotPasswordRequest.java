package org.elena.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;

public record ForgotPasswordRequest(
        @Nullable @Size(max = 200) @JsonProperty("email") String email,
        @Nullable @Size(max = 200) @JsonProperty("username") String username) {
}
