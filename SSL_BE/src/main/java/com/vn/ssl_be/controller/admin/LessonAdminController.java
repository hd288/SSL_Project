package com.vn.ssl_be.controller.admin;

import com.vn.ssl_be.domain.lesson.dto.request.LessonRequest;
import com.vn.ssl_be.domain.lesson.model.Lesson;
import com.vn.ssl_be.domain.lesson.service.LessonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/lessons")
public class LessonAdminController {
    private final LessonService lessonService;

    @GetMapping
    public ResponseEntity<List<Lesson>> getLessons() {
        return new ResponseEntity<>(lessonService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{lessonId}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable Long lessonId) {
        return new ResponseEntity<>(lessonService.findById(lessonId), HttpStatus.OK);
    }
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<List<Lesson>> getLessonByCourseId(@PathVariable("courseId") String courseId) {
        return new ResponseEntity<>(lessonService.findAllLessonByCourseId(courseId), HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Lesson>> getLessonsByTitle(@RequestParam("search") String keyword)  {
        return new ResponseEntity<>(lessonService.findAllLessonByCourseId(keyword), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> addLesson(@Valid @ModelAttribute LessonRequest lessonRequest) {
        try {
            Lesson createdLesson = lessonService.save(lessonRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdLesson);
        }catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PutMapping("/{lessonId}")
    public ResponseEntity<?> editLesson(@Valid @ModelAttribute LessonRequest lessonRequest,
                                        @PathVariable Long lessonId) {
        try {
            Lesson existingLesson = lessonService.findById(lessonId);
            lessonRequest.setLessonId(existingLesson.getLessonId());
            Lesson updateLesson = lessonService.save(lessonRequest);
            return ResponseEntity.ok(updateLesson);
        }catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @DeleteMapping("/{lessonId}")
    public ResponseEntity<String> deleteLessonById(@PathVariable Long lessonId) {
        lessonService.deleteById(lessonService.findById(lessonId).getLessonId());
        return ResponseEntity.ok("Delete Successfully");
    }
}
