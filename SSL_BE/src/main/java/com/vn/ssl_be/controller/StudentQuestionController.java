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

    //send student'answer to back-end, include [{studentAnswer, questionId, stuentAnswer}]
    @PostMapping("/answer")
    public ResponseEntity<List<StudentQuestion>> handlePostAnswer(@RequestBody List<StudentQuestionRequest> studentQuestionRequests) {
        List<StudentQuestion> savedStudentQuestions = studentQuestionService.save(studentQuestionRequests);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudentQuestions);
    }

    //count question in a lesson, lessonId is required (admin dashboard)
    @GetMapping("/count-questions/{lessonId}")
    public ResponseEntity<Integer> countQuestionsByLessonId(@PathVariable Long lessonId) {
        int count = questionService.countByLessonId(lessonId);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //get data from back-end, student'answer, lessonId is required.
    @GetMapping("/student-answers/{lessonId}")
    public ResponseEntity<List<String>> getStudentAnswersByLessonId(@PathVariable Long lessonId) {
        List<String> studentAnswers = studentQuestionService.getStudentAnswersByLessonId(lessonId);
        if (studentAnswers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(studentAnswers, HttpStatus.OK);
        }
    }

    //calculate score in a lesson, such as: a calculate result button
    @GetMapping("/score/{lessonId}")
    public ResponseEntity<Double> calculateScoreOfLesson(@PathVariable Long lessonId) {
        double scrore = studentQuestionService.calculateScoreOfLesson(lessonId);
        return new ResponseEntity<>(scrore, HttpStatus.OK);
    }

    //clear student'answer, such as: a clear button
    @DeleteMapping("/delete-questions/{lessonId}")
    public ResponseEntity<String> deleteQuestionsOfStudent(@PathVariable Long lessonId) {
        studentQuestionService.deleteStudentQuestionsByQuestion_Lesson_LessonId(lessonId);
        return ResponseEntity.ok().body("Delete Successfully");
    }
}
