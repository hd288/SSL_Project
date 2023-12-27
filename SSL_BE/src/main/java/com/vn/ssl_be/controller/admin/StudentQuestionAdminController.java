package com.vn.ssl_be.controller.admin;

import com.vn.ssl_be.domain.lesson.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class StudentQuestionAdminController {
    private final QuestionService questionService;

    //count question in a lesson, lessonId is required (admin dashboard)
    @GetMapping("/count-questions/{lessonId}")
    public ResponseEntity<Integer> countQuestionsByLessonId(@PathVariable Long lessonId) {
        int count = questionService.countByLessonId(lessonId);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

}
