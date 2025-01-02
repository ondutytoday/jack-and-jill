package org.elena.api.controller;

import org.elena.dto.auth.AuthenticationRequest;
import org.elena.dto.auth.ChangePasswordRequest;
import org.elena.dto.auth.ForgotPasswordRequest;
import org.elena.dto.auth.RegisterRequest;
import org.elena.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Authorization", description = "Authentication and authorization API")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @Operation(summary = "Login")
    @PostMapping(path = "/login")
    public ResponseEntity<?> authenticate(@Valid @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @Operation(summary = "Register new user")
    @PostMapping(path = "/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @Operation(summary = "Change password")
    @PostMapping(path = "/change-password")
    public ResponseEntity<?> register(@Valid @RequestBody ChangePasswordRequest request) {
        return ResponseEntity.ok(authenticationService.changePassword(request));
    }

    @Operation(summary = "Forgot password")
    @PostMapping(path = "/forgot-password")
    public ResponseEntity<?> register(@Valid @RequestBody ForgotPasswordRequest request) {
        authenticationService.sendEmail(request);
        return ResponseEntity.ok().build();
    }
}
