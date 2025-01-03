package org.elena.service;

import org.elena.dto.auth.AuthenticationRequest;
import org.elena.dto.auth.AuthenticationResponse;
import org.elena.dto.auth.ForgotPasswordRequest;
import org.elena.dto.auth.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    AuthenticationResponse register(RegisterRequest registerRequest);

    void sendEmail(ForgotPasswordRequest request);
}
