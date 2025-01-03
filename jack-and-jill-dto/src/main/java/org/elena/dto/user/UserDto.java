package org.elena.dto.user;

import org.elena.dto.auth.UserRole;

public record UserDto(
        String username,
        String email,
        UserRole role
) {
}
