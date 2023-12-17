package com.vn.ssl_be.controller;

import com.vn.ssl_be.domain.course.dto.CourseDto;
import com.vn.ssl_be.domain.course.model.Category;
import com.vn.ssl_be.domain.course.model.Course;
import com.vn.ssl_be.domain.course.service.CategoryService;
import com.vn.ssl_be.domain.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/home")
public class CourseWebController {
    private final CourseService courseService;
    private final CategoryService categoryService;


        @GetMapping("/menu")
        public ResponseEntity<Map<String, Object>> getMenu() {
            Map<String, Object> response = new HashMap<>();
            List<Category> categories = categoryService.findAll();
            List<Map<String, Object>> categoryCourseList = new ArrayList<>();

            for (Category category : categories) {
                Map<String, Object> categoryCourseMap = new HashMap<>();
                categoryCourseMap.put("category", category);
                List<CourseDto> courses = courseService.allCourse();
                categoryCourseMap.put("courses", courses);
                categoryCourseList.add(categoryCourseMap);
            }
            response.put("categories", categoryCourseList);
            return ResponseEntity.ok(response);
        }
}
