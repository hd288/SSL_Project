package com.vn.ssl_be.domain.course.service;

import com.vn.ssl_be.domain.course.dto.request.CategoryRequest;
import com.vn.ssl_be.domain.course.dto.response.CategoryResponse;
import com.vn.ssl_be.domain.course.exception.CourseException;
import com.vn.ssl_be.domain.course.model.Category;

import java.util.List;
public interface CategoryService {
    /* 4 Method Basic */
    List<Category> findAll();
    Category findById(Long categoryId) throws CourseException;
    Category save (CategoryRequest categoryRequest);
    void deleteById(Long categoryId);

    /**************************/
    /* Method Advance */
    List<Category> findAllCategoryByNameOrDescription(String keyword);
    List<CategoryResponse> getCategoriesAndQuantityCourses();
}
