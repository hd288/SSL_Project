package com.vn.ssl_be.domain.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "refresh_token")
public class RefreshToken {
    @Id
    @Column(name="user_id")
    private String userId;

    @OneToOne (fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expiryDate;

    @Override
    public String toString() {
        return "";
    }
}
