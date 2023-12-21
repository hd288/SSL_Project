package com.vn.ssl_be.domain.student.serviceimpl;

import com.vn.ssl_be.domain.security.model.User;
import com.vn.ssl_be.domain.student.dto.StudentProfileResponse;
import com.vn.ssl_be.domain.student.exception.StudentException;
import com.vn.ssl_be.domain.student.model.Student;
import com.vn.ssl_be.domain.student.repository.StudentRepository;
import com.vn.ssl_be.domain.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper mapper;

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

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(String userId) throws StudentException{
        return studentRepository.findById(userId).orElseThrow(() -> StudentException.notFound("Could not find Id"));
    }

    @Override
    public void deleteById(String userId) {
        studentRepository.deleteById(userId);
    }

    @Override
    public StudentProfileResponse getStudentProfile(String userId) {
        Student student = findById(userId);
        return mapper.map(student.getUser(), StudentProfileResponse.class);
    }
}
