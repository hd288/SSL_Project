package com.vn.ssl_be.domain.security.service;

import com.vn.ssl_be.domain.security.dto.request.LoginRequest;
import com.vn.ssl_be.domain.security.dto.request.SignupRequest;
import com.vn.ssl_be.domain.security.dto.response.MessageResponse;
import com.vn.ssl_be.domain.security.dto.response.UserInfoResponse;

public interface AuthenticationService {
    UserInfoResponse handleAuthenticateUser(LoginRequest loginRequest);
    MessageResponse handleRegisterUser(SignupRequest signupRequest);
    MessageResponse handleLogoutUser();
}
