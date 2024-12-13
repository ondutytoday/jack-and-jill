package org.elena.api.controller;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "User", description = "The User API")
public class UserController {

    @Operation(summary = "Get user by id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@Parameter @PathVariable("id") @NotNull Long id) {
        return ResponseEntity.ok().build();
    }
}
