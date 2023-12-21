package com.vn.ssl_be.controller;

import com.vn.ssl_be.domain.lesson.dto.StudentQuestionRequest;
import com.vn.ssl_be.domain.lesson.service.LessonService;
import com.vn.ssl_be.domain.lesson.service.QuestionService;
import com.vn.ssl_be.domain.student.model.StudentQuestion;
import com.vn.ssl_be.domain.student.service.StudentQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StudentQuestionController {
    private final QuestionService questionService;
    private final LessonService lessonService;
    private final StudentQuestionService studentQuestionService;

    @PostMapping("/answer")
    public ResponseEntity<List<StudentQuestion>> handlePostAnswer(@RequestBody List<StudentQuestionRequest> studentQuestionRequests) {
        List<StudentQuestion> savedStudentQuestions = studentQuestionService.save(studentQuestionRequests);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudentQuestions);
    }

    @GetMapping("/count-questions/{lessonId}")
    public ResponseEntity<Integer> countQuestionsByLessonId(@PathVariable Long lessonId) {
        int count = questionService.countByLessonId(lessonId);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/student-answers/{lessonId}")
    public ResponseEntity<List<String>> getStudentAnswersByLessonId(@PathVariable Long lessonId) {
        List<String> studentAnswers = studentQuestionService.getStudentAnswersByLessonId(lessonId);
        if (studentAnswers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(studentAnswers, HttpStatus.OK);
        }
    }

    @GetMapping("/score/{lessonId}")
    public ResponseEntity<Double> calculateScoreOfLesson(@PathVariable Long lessonId) {
        double scrore = studentQuestionService.calculateScoreOfLesson(lessonId);
        return new ResponseEntity<>(scrore, HttpStatus.OK);
    }

    @DeleteMapping("/delete-questions/{lessonId}")
    public ResponseEntity<String> deleteQuestionsOfStudent(@PathVariable Long lessonId) {
        studentQuestionService.deleteStudentQuestionsByQuestion_Lesson_LessonId(lessonId);
        return ResponseEntity.ok().body("Delete Successfully");
    }
}
