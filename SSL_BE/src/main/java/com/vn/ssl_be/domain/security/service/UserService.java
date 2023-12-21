package com.vn.ssl_be.domain.security.service;

import com.vn.ssl_be.domain.security.dto.request.ChangePasswordRequest;
import com.vn.ssl_be.domain.security.exception.UserException;
import com.vn.ssl_be.domain.security.model.User;

public interface UserService {
    User findById(String userId) throws UserException;
    User findByEmail(String email);
    Boolean existsByEmail(String email);
    void changePassword(ChangePasswordRequest changePasswordRequest);

    void toggleStatusById(String userId);
}
