package com.vn.ssl_be.controller;

import com.vn.ssl_be.domain.student.dto.StudentProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class StudentWebController {
    //get student profile
//    @GetMapping("/students/{userId}")
//    public ResponseEntity<StudentProfileResponse>()
}
