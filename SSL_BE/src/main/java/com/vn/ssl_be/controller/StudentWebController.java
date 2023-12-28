package com.vn.ssl_be.controller;

import com.vn.ssl_be.domain.security.dto.request.ChangePasswordRequest;
import com.vn.ssl_be.domain.security.model.User;
import com.vn.ssl_be.domain.security.service.UserService;
import com.vn.ssl_be.domain.security.serviceimpl.UserDetailsImpl;
import com.vn.ssl_be.domain.student.dto.StudentRequest;
import com.vn.ssl_be.domain.student.dto.StudentResponse;
import com.vn.ssl_be.domain.student.model.Student;
import com.vn.ssl_be.domain.student.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.apache.tomcat.util.http.fileupload.FileUploadBase.MULTIPART_FORM_DATA;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
//@PreAuthorize("hasRole('STUDENT')")
public class StudentWebController {
    private final StudentService studentService;
    private final UserService userService;

    //get student profile
    @GetMapping("/profile")
    public ResponseEntity<StudentResponse> getStudentProfile(){
        return new ResponseEntity<>(studentService.getStudentProfile(), HttpStatus.OK);
    }

    //student edit profile
    @PutMapping(value = "/profile")
    public ResponseEntity<StudentResponse> editStudentProfile(@ModelAttribute StudentRequest studentRequest){
            StudentResponse updateStudent = studentService.updateStudentProfile(studentRequest);
            return ResponseEntity.ok(updateStudent);
    }

    @PutMapping("/password")
    public ResponseEntity<String> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest){
        userService.changePassword(changePasswordRequest);
        return ResponseEntity.ok("Updated password successfully");
    }
}
