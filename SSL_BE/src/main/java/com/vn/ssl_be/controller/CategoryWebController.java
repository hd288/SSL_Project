package com.vn.ssl_be.controller;

import com.vn.ssl_be.domain.course.dto.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class CategoryWebController {
    private final CategoryService categoryService;

    //Show list categories for user
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> getCategoriesForUser() {
        return new ResponseEntity<>(categoryService.getCategoriesAndQuantityCourses(), HttpStatus.OK);
    }
}
