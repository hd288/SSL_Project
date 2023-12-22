package com.vn.ssl_be.domain.student.serviceimpl;

import com.vn.ssl_be.common.exception.DomainException;
import com.vn.ssl_be.common.util.UploadService;
import com.vn.ssl_be.domain.security.model.User;
import com.vn.ssl_be.domain.security.repository.UserRepository;
import com.vn.ssl_be.domain.security.serviceimpl.UserDetailsImpl;
import com.vn.ssl_be.domain.student.dto.StudentRequest;
import com.vn.ssl_be.domain.student.dto.StudentResponse;
import com.vn.ssl_be.domain.student.exception.StudentException;
import com.vn.ssl_be.domain.student.model.Student;
import com.vn.ssl_be.domain.student.repository.StudentRepository;
import com.vn.ssl_be.domain.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper mapper;
    private final UploadService uploadService;
    private final UserRepository userRepository;

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
    public StudentResponse getStudentProfile() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow(() -> DomainException.notFound(userDetails.getUsername()));
        return mapper.map(user, StudentResponse.class);
    }

    @Override
    public StudentResponse updateStudentProfile(StudentRequest studentRequest) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow(() -> DomainException.notFound(userDetails.getUsername()));

        mapper.map(studentRequest, user);
        if(studentRequest.getFileAvatar() != null){
            user.setImage(uploadService.uploadFile(studentRequest.getFileAvatar()));
        }
        userRepository.save(user);

        return mapper.map(user, StudentResponse.class );
    }
}
