package com.vn.ssl_be.controller.admin;

import com.vn.ssl_be.domain.security.service.UserService;
import com.vn.ssl_be.domain.student.dto.StudentResponse;
import com.vn.ssl_be.domain.student.exception.StudentException;
import com.vn.ssl_be.domain.student.model.Student;
import com.vn.ssl_be.domain.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin/accounts")
public class UserAdminController {
    private final StudentService studentService;
    private final UserService userService;

    // Get List Students For Admin
    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAccount() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }
    // Get Student By Id For Admin
    @GetMapping("/{userId}")
    public ResponseEntity<StudentResponse> getAccountById(@PathVariable String userId) throws StudentException {
        return new ResponseEntity<>(studentService.findById(userId), HttpStatus.OK);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<String> toggleStatusById(@PathVariable String userId) {
        userService.toggleStatusById(userId);
        return ResponseEntity.ok("Account status changed successfully");
    }

}
