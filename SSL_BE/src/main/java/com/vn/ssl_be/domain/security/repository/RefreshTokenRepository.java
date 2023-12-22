package com.vn.ssl_be.domain.security.repository;

import com.vn.ssl_be.domain.security.model.RefreshToken;
import com.vn.ssl_be.domain.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    @Query(value = "DELETE FROM refresh_token where token = ?1",nativeQuery = true)
    @Transactional
    void deleteByToken(String refreshToken);

    @Modifying
    int deleteByUser(User user);
}
