package org.elena.mapper;

import org.elena.dto.auth.UserRole;
import org.elena.dto.user.UserDto;
import org.elena.entity.User;
import org.elena.entity.enums.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "role", source = "role")
    UserDto toUserDto(User user);

    default UserRole map(Role role) {
        return switch (role) {
            case ADMIN, SUPERADMIN -> UserRole.ADMIN;
            case USER -> UserRole.JUDGE;
            case READER -> UserRole.PARTICIPANT;
        };
    }

    default Role map(UserRole userRole) {
        return switch (userRole) {
            case JUDGE -> Role.USER;
            case PARTICIPANT -> Role.READER;
            case ADMIN -> Role.ADMIN;
        };
    }
}
