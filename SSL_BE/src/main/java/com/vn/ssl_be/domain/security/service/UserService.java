package com.vn.ssl_be.domain.security.service;

import com.vn.ssl_be.domain.security.model.User;

public interface UserService {
    User findByEmail(String email);
    Boolean existsByEmail(String email);
}
