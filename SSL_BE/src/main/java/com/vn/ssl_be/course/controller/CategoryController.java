package com.vn.ssl_be.course.controller;

import com.vn.ssl_be.course.application.service.CategoryService;
import com.vn.ssl_be.course.application.serviceImpl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;
}
