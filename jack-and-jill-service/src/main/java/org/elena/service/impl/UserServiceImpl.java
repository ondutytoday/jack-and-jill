package org.elena.service.impl;

import org.elena.dto.user.UserDto;
import org.elena.mapper.UserMapper;
import org.elena.repository.UserRepository;
import org.elena.service.UserService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto findById(Long id) {
        return UserMapper.INSTANCE.toUserDto(userRepository.findById(id).orElse(null));
    }
}
