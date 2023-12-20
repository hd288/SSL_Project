package com.vn.ssl_be.domain.student.service;

import com.vn.ssl_be.domain.security.model.User;
import com.vn.ssl_be.domain.student.model.Student;

public interface StudentService {
    Student createStudent(User user);
    void save(Student student);
}
