package org.elena.service.impl;

import org.elena.auth.JwtTokenProvider;
import org.elena.dto.auth.AuthenticationRequest;
import org.elena.dto.auth.AuthenticationResponse;
import org.elena.dto.auth.ChangePasswordRequest;
import org.elena.dto.auth.ForgotPasswordRequest;
import org.elena.dto.auth.RegisterRequest;
import org.elena.dto.auth.UserRole;
import org.elena.entity.User;
import org.elena.entity.enums.Role;
import org.elena.entity.enums.Status;
import org.elena.repository.UserRepository;
import org.elena.service.AuthenticationService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional(readOnly = true)
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        User user = userRepository.findByUsername(request.username()).orElse(userRepository.findByEmail(request.username())
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("User %s doesn't exists", request.username()))));
        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRole().name());
        return new AuthenticationResponse(token);
    }

    @Override
    @Transactional
    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.username())
                .password(request.password())
                .email(request.email())
                .role(getRole(request.role()))
                .status(Status.ACTIVE)
                .build();
        User savedUser = userRepository.save(user);
        String token = jwtTokenProvider.createToken(savedUser.getUsername(), savedUser.getRole().name());
        return new AuthenticationResponse(token);
    }

    @Override
    public AuthenticationResponse changePassword(ChangePasswordRequest request) {
        return null;
    }

    @Override
    @Async
    public void sendEmail(ForgotPasswordRequest request) {

    }

    private Role getRole(UserRole userRole) {
        return switch (userRole) {
            case JUDGE -> Role.USER;
            case PARTICIPANT -> Role.READER;
        };
    }
}
