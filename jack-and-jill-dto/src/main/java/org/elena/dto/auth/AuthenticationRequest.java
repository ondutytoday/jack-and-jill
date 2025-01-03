package org.elena.dto.auth;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record AuthenticationRequest(
        @NotEmpty @Size(max = 200) @JsonProperty("username") String username,
        @NotEmpty @Size(max = 200) @JsonProperty("password") String password
) {
}
