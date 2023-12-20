package com.vn.ssl_be.controller;

import com.vn.ssl_be.domain.lesson.dto.response.QuestionResponse;
import com.vn.ssl_be.domain.student.dto.response.StudentQuestionResponse;
import com.vn.ssl_be.domain.student.service.StudentQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answer")
@RequiredArgsConstructor
public class StudentQuestionController {
    private final StudentQuestionService studentQuestionService;
    @GetMapping()
    public ResponseEntity<List<StudentQuestionResponse>> getAllStudentResponse() {
        return new ResponseEntity<>(studentQuestionService.findAllQuestionsForStudent(), HttpStatus.OK);
    }
}
