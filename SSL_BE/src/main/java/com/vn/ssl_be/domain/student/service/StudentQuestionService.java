package com.vn.ssl_be.domain.student.service;

import com.vn.ssl_be.domain.student.dto.response.StudentQuestionResponse;
import com.vn.ssl_be.domain.student.model.StudentQuestion;

import java.util.List;
import java.util.UUID;

public interface StudentQuestionService {
    List<StudentQuestion> findAll();

    List<StudentQuestionResponse> findAllQuestionsForStudent();

    List<StudentQuestion> findByStudent_UserId(UUID userId);

    List<StudentQuestion> findByQuestion_Lesson_LessonId(Long lessonId);

    double calculateScoreByLessonId(Long lessonId);
}
