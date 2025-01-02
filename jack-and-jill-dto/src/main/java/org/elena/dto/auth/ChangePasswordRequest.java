package org.elena.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record ChangePasswordRequest(
        @NotEmpty @Size(max = 200) @JsonProperty("username") String username,
        @NotEmpty @Size(max = 200) @JsonProperty("current_password") String currentPassword,
        @NotEmpty @Size(max = 200) @JsonProperty("new_password") String newPassword,
        @NotEmpty @Size(max = 200) @JsonProperty("confirm_password") String confirmPassword) {
}
