package com.vn.ssl_be.controller.admin;

import com.vn.ssl_be.domain.course.exception.CourseException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/coures")
public class CourseAdminController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable String courseId) {
        return new ResponseEntity<>(courseService.findById(courseId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@ModelAttribute CourseRequest courseRequest) {
        try {
            Course createdCategory = courseService.save(courseRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> editCourse(@ModelAttribute CourseRequest courseRequest,
                                             @PathVariable String courseId) {
        try {
            Course existingCourse = courseService.findById(courseId);
            courseRequest.setCourseId(existingCourse.getCourseId());
            Course updatedCourse = courseService.save(courseRequest);
            return ResponseEntity.ok(updatedCourse);

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }
    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable String courseId) throws CourseException {
        Course course = courseService.findById(courseId);
        courseService.deletedById(course.getCourseId());
        return ResponseEntity.ok().body("Deleta Successfully");
    }
}
