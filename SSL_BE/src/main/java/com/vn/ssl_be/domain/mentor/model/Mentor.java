package com.vn.ssl_be.domain.mentor.model;

import com.vn.ssl_be.domain.security.domain.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mentor")
public class Mentor {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private UUID userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;

    @Column(nullable = false)
    private String degree;
    @Column(nullable = false)
    private int experience;
}
