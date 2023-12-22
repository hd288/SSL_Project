package com.vn.ssl_be.domain.student.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private String firstName;

    private String lastName;


    private String phoneNumber;

    private boolean gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    private String address;

    private MultipartFile fileAvatar;

}
