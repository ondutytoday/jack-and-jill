package org.elena.api.controller;

import org.elena.dto.auth.ChangePasswordRequest;
import org.elena.dto.auth.ForgotPasswordRequest;
import org.elena.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "User", description = "The User API")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Get user by id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@Parameter @PathVariable("id") @NotNull Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @Operation(summary = "Change password")
    @PatchMapping(path = "/change-password")
    public ResponseEntity<?> changePassword(
            @Valid @RequestBody ChangePasswordRequest request,
            @AuthenticationPrincipal UserDetails userDetails) {
        userService.changePassword(request, userDetails);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Forgot password")
    @PostMapping(path = "/forgot-password")
    public ResponseEntity<?> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request) {
        userService.sendEmail(request);
        return ResponseEntity.ok().build();
    }
}
