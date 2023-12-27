package com.vn.ssl_be.controller;

import com.vn.ssl_be.domain.lesson.dto.request.QuestionRequest;
import com.vn.ssl_be.domain.lesson.dto.response.QuestionResponse;
import com.vn.ssl_be.domain.lesson.exception.LessonException;
import com.vn.ssl_be.domain.lesson.model.Question;
import com.vn.ssl_be.domain.lesson.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    // get all questions
    @GetMapping("/questions")
    public ResponseEntity<List<QuestionResponse>> getAllQuestions() {
        return new ResponseEntity<>(questionService.findAllQuestions(), HttpStatus.OK);
    }

    // get question by question Id
    @GetMapping("/questions/{id}")
    public ResponseEntity<Question> getQuestionsByid(@PathVariable Long id) {
        return new ResponseEntity<>(questionService.findById(id), HttpStatus.OK);
    }

    // get questions by lesson
    @GetMapping("/lesson-questions/{lessonId}")
    public ResponseEntity<List<QuestionResponse>> getQuestionsByLesson(@PathVariable Long lessonId) {
        return new ResponseEntity<>(questionService.findAllByLessonLessonId(lessonId), HttpStatus.OK);
    }

    //get correctAnswer by lessonId
    @GetMapping("/correct-answer/{lessonId}")
    public ResponseEntity<List<String>> getCorrectAnswersByLessonId(@PathVariable Long lessonId) {
        List<String> coreectAnswerList = questionService.getCorrectAnswersByLessonId(lessonId);
        return new ResponseEntity<>(coreectAnswerList, HttpStatus.OK);
    }
}
