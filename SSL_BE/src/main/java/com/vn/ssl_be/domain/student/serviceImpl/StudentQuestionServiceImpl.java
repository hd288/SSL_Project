package com.vn.ssl_be.domain.student.serviceImpl;

import com.vn.ssl_be.domain.student.dto.response.StudentQuestionResponse;
import com.vn.ssl_be.domain.student.model.StudentQuestion;
import com.vn.ssl_be.domain.student.repository.StudentQuestionRepository;
import com.vn.ssl_be.domain.student.service.StudentQuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentQuestionServiceImpl implements StudentQuestionService {
    private final StudentQuestionRepository studentQuestionRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<StudentQuestion> findAll() {
        return studentQuestionRepository.findAll();
    }

    @Override
    public List<StudentQuestionResponse> findAllQuestionsForStudent() {
        return findAll().stream()
                .map(studentQuestion -> modelMapper.map(studentQuestion, StudentQuestionResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentQuestion> findByStudent_UserId(UUID userId) {
        return null;
    }

    @Override
    public List<StudentQuestion> findByQuestion_Lesson_LessonId(Long lessonId) {
        return null;
    }

    @Override
    public double calculateScoreByLessonId(Long lessonId) {
        return 0;
    }
}
