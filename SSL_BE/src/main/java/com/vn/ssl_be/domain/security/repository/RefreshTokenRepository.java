package com.vn.ssl_be.domain.security.repository;

import com.vn.ssl_be.domain.security.model.RefreshToken;
import com.vn.ssl_be.domain.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
    Optional<RefreshToken> findByToken(String token);
    @Query(value = "DELETE FROM RefreshToken r WHERE r.token = :token")
    void deleteAllByToken(@Param("token") String refreshToken);
    @Modifying
    int deleteByUser(User user);
}
