package org.elena.service;

import org.elena.dto.user.UserDto;

public interface UserService {

    UserDto findById(Long id);
}
