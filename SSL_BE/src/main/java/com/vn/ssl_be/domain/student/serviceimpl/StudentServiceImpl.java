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
import jakarta.servlet.http.Part;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<StudentResponse> findAll() {
        return studentRepository.findAll().stream().map(student -> mapper.map(student.getUser(),StudentResponse.class)).collect(Collectors.toList());
    }


    @Override
    public StudentResponse findById(String userId) throws StudentException{
        Student student = studentRepository.findById(userId).orElseThrow(() -> StudentException.notFound("Could not find Id"));
        return mapper.map(student.getUser(), StudentResponse.class);
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

//        mapper.map(studentRequest, user);
        if(studentRequest.getFirstName() != null) {
            user.setFirstName(studentRequest.getFirstName());
        }

        if(studentRequest.getLastName() != null) {
            user.setLastName(studentRequest.getLastName());
        }

        if(studentRequest.getAddress() != null) {
            user.setAddress(studentRequest.getAddress());
        }

        if(studentRequest.getPhoneNumber() != null) {
            user.setPhoneNumber(studentRequest.getPhoneNumber());
        }

        if(studentRequest.getBirthDay() != null) {
            user.setBirthDay(studentRequest.getBirthDay());
        }

        if(studentRequest.getGender() != null) {
            user.setGender(studentRequest.getGender().equals("men"));
        }


        if(studentRequest.getFileAvatar() != null){
            user.setImage(uploadService.uploadFile(studentRequest.getFileAvatar()));
        }


        return mapper.map(userRepository.save(user), StudentResponse.class );
    }

    @Override
    public StudentResponse getStudentProfileByEmail(String email) {
        return null;
    }
}
