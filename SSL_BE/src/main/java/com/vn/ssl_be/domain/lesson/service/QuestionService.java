package com.vn.ssl_be.domain.lesson.service;

import com.vn.ssl_be.domain.lesson.dto.request.QuestionRequest;
import com.vn.ssl_be.domain.lesson.dto.response.QuestionResponse;
import com.vn.ssl_be.domain.lesson.exception.LessonException;
import com.vn.ssl_be.domain.lesson.model.Question;

import java.util.List;

public interface QuestionService {

    List<Question> findAll();

    List<QuestionResponse> findAllQuestions();

    Question findById(Long id) throws LessonException;

    // Add new question for mentor and admin
    Question save(QuestionRequest questionRequest);

    // Add new question for mentor and admin
    void deletedById(Long id);

    // Advance method
    List<QuestionResponse> findAllByLessonLessonId(Long lessonId);

    void deleteAllByLesson_LessonId(Long lessonId);

    // count numbers of questions by lessonId

    int countByLessonId(Long lessonId);

    List<String> getCorrectAnswersByLessonId(Long lessonId);
}
