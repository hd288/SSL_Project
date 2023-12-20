package com.vn.ssl_be.domain.security.model;

import com.vn.ssl_be.domain.mentor.model.Mentor;
import com.vn.ssl_be.domain.student.model.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private String userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "gender", nullable = false)
    private boolean gender;

    @Column(name = "birth_day")
    @Temporal(TemporalType.DATE)
    private Date birthDay;

    @Column(name = "address")
    private String address;

    @Column(name = "image")
    private String image;

    @Column(name = "enable", nullable = false)
    private boolean enable;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Mentor mentor;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Student student;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RefreshToken refreshToken;

    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Transient
    private String fullName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public String getFullName() {
        return firstName +  " " + lastName;
    }
}
