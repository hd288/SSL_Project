package com.vn.ssl_be.domain.student.model;
import com.vn.ssl_be.domain.security.domain.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "user_id")
    private UUID userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;

    @Column
    private String performance;
}
