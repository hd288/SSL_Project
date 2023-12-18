package com.vn.ssl_be.controller;

import com.vn.ssl_be.domain.course.dto.CourseResponse;
import com.vn.ssl_be.domain.course.model.Category;
import com.vn.ssl_be.domain.course.service.CategoryService;
import com.vn.ssl_be.domain.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class CourseWebController {
    private final CourseService courseService;
    private final CategoryService categoryService;

    //Hiển thị danh sách danh mục tại home
    @GetMapping("/menu")
    public ResponseEntity<Map<String, Object>> getMenu() {
        Map<String, Object> response = new HashMap<>();
        List<Category> categories = categoryService.findAll();
        List<Map<String, Object>> categoryCourseList = new ArrayList<>();

        for (Category category : categories) {
            Map<String, Object> categoryCourseMap = new HashMap<>();
            categoryCourseMap.put("category", category);
            List<CourseResponse> courses = courseService.findAllCourseForUser();
            categoryCourseMap.put("courses", courses);
            categoryCourseList.add(categoryCourseMap);
        }
        response.put("categories", categoryCourseList);
        return ResponseEntity.ok(response);
    }
}
