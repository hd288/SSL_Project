package com.vn.ssl_be.domain.security.repository;

import com.vn.ssl_be.domain.security.model.RefreshToken;
import com.vn.ssl_be.domain.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(User user);
    @Modifying
    @Query(value = "delete  from RefreshToken  r where r.token = ?1")
    @Transactional
    int deleteByToken(String token);
}
