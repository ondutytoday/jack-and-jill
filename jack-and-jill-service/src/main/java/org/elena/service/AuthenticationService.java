package org.elena.service;

import org.elena.dto.auth.AuthenticationRequest;
import org.elena.dto.auth.AuthenticationResponse;
import org.elena.dto.auth.ChangePasswordRequest;
import org.elena.dto.auth.ForgotPasswordRequest;
import org.elena.dto.auth.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    AuthenticationResponse register(RegisterRequest registerRequest);

    AuthenticationResponse changePassword(ChangePasswordRequest request);

    void sendEmail(ForgotPasswordRequest request);
}
