package com.vn.ssl_be.controller;

import com.vn.ssl_be.domain.course.model.Course;
import com.vn.ssl_be.domain.course.service.CategoryService;
import com.vn.ssl_be.domain.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class CourseAdminController {
    private final CourseService courseService;
    private final CategoryService categoryService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourse() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

}
