package com.vn.ssl_be.domain.student.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private boolean gender;

    @Temporal(TemporalType.DATE)
    private Date birthDay;

    private String address;

    private String image;

    @Temporal(TemporalType.DATE)
    private Date createDate;
}
