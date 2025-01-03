package org.elena.service.impl;

import org.elena.dto.auth.ChangePasswordRequest;
import org.elena.dto.user.UserDto;
import org.elena.entity.User;
import org.elena.mapper.UserMapper;
import org.elena.repository.UserRepository;
import org.elena.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto findById(Long id) {
        return UserMapper.INSTANCE.toUserDto(userRepository.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public void changePassword(ChangePasswordRequest request, UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalStateException("User with username not found: " + userDetails.getUsername()));

        if (!passwordEncoder.matches(request.currentPassword(), userDetails.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        if (!request.newPassword().equals(request.confirmPassword())) {
            throw new IllegalStateException("Password are not the same");
        }
        user.setPassword(passwordEncoder.encode(request.newPassword()));

        userRepository.save(user);
    }
}
