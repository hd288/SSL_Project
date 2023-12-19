package com.vn.ssl_be.controller;

import com.vn.ssl_be.domain.course.exception.CourseException;
import com.vn.ssl_be.domain.course.model.Category;
import com.vn.ssl_be.domain.course.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId) throws CourseException {
        return new ResponseEntity<>(categoryService.findById(categoryId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        try {
            Category createdCategory = categoryService.save(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> editCategory(@RequestBody Category category,
                                                 @PathVariable Long categoryId) {
        try {
            Category existingCategory = categoryService.findById(categoryId);
            category.setCategoryId(existingCategory.getCategoryId());
            Category updatedCategory = categoryService.save(category);
            return ResponseEntity.ok(updatedCategory);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) throws CourseException {
        Category category = categoryService.findById(categoryId);
        categoryService.deleteById(category.getCategoryId());
        return ResponseEntity.ok().body("Deleta Successfully");
    }
}