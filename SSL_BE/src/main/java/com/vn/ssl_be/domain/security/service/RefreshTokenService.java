package com.vn.ssl_be.domain.security.service;

import com.vn.ssl_be.domain.security.model.RefreshToken;
import com.vn.ssl_be.domain.security.model.User;

import java.util.Optional;

public interface RefreshTokenService {

    Optional<RefreshToken> findByToken(String refreshToken);
    RefreshToken createRefreshToken(User user);
    RefreshToken verifyExpiration(RefreshToken refreshToken);
    void deleteByToken(RefreshToken refreshToken);
    void save(RefreshToken refreshToken);
    void deleteByUserId(String userId);
}
