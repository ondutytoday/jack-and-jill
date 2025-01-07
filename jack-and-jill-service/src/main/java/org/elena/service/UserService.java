package org.elena.service;

import org.elena.dto.auth.ChangePasswordRequest;
import org.elena.dto.auth.ForgotPasswordRequest;
import org.elena.dto.user.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDto findById(Long id);

    void changePassword(ChangePasswordRequest request, UserDetails userDetails);

    void sendEmail(ForgotPasswordRequest request);
}
