package com.vn.ssl_be.domain.student.serviceimpl;

import com.vn.ssl_be.domain.security.model.User;
import com.vn.ssl_be.domain.student.model.Student;
import com.vn.ssl_be.domain.student.repository.StudentRepository;
import com.vn.ssl_be.domain.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(User user) {
        Student student = new Student();
        student.setUser(user);
        return student;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
}
