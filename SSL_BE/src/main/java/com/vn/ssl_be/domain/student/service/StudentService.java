package com.vn.ssl_be.domain.student.service;

import com.vn.ssl_be.domain.security.model.User;
import com.vn.ssl_be.domain.student.dto.StudentRequest;
import com.vn.ssl_be.domain.student.dto.StudentResponse;
import com.vn.ssl_be.domain.student.exception.StudentException;
import com.vn.ssl_be.domain.student.model.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {
    Student createStudent(User user);
    void save(Student student);
    List<Student> findAll();
    Student findById(String userId) throws StudentException;
    void deleteById(String userId);
    StudentResponse getStudentProfile();
    StudentResponse updateStudentProfile(StudentRequest studentRequest);
    StudentResponse getStudentProfileByEmail(String email);

}
