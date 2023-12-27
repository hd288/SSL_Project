package com.vn.ssl_be.controller.admin;

import com.vn.ssl_be.domain.lesson.dto.request.QuestionRequest;
import com.vn.ssl_be.domain.lesson.exception.LessonException;
import com.vn.ssl_be.domain.lesson.model.Question;
import com.vn.ssl_be.domain.lesson.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class QuestionAdminController {
    private final QuestionService questionService;
    // add new question (lesson ID is required), need resource
    @PostMapping("/question")
    public ResponseEntity<Question> addQuestion(@RequestBody QuestionRequest questionRequest) {
        try {
            Question createdQuestion = questionService.save(questionRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestion);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    //update question (by question Id)
    @PutMapping("/question/{questionId}")
    public ResponseEntity<Question> editQuestion(@RequestBody QuestionRequest questionRequest,
                                                 @PathVariable Long questionId) {
        try {
            Question existingQuestion = questionService.findById(questionId);
            questionRequest.setQuestionId(existingQuestion.getQuestionId());
            Question updatedCategory = questionService.save(questionRequest);
            return ResponseEntity.ok(updatedCategory);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    //delete question (by question Id)
    @DeleteMapping("/list-questions/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long questionId) {
        Question question = questionService.findById(questionId);
        questionService.deletedById(question.getQuestionId());
        return ResponseEntity.ok().body("Deleta Successfully");
    }

    //delete all by lesson Id
    @DeleteMapping("/delete-list-questions/{lessonId}")
    public ResponseEntity<String> deleteAllQuestionsByLessonId(@PathVariable Long lessonId) {
        try {
            questionService.deleteAllByLesson_LessonId(lessonId);
            return ResponseEntity.ok("Delete Successfully");
        } catch (LessonException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
