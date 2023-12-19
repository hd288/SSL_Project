package com.vn.ssl_be.domain.course.service;

import com.vn.ssl_be.domain.course.dto.CategoryDto;
import com.vn.ssl_be.domain.course.exception.CourseException;
import com.vn.ssl_be.domain.course.model.Category;

import java.util.List;
public interface CategoryService {
    /* 4 Method Basic */
    List<Category> findAll();
    Category findById(Long categoryId) throws CourseException;
    Category save (Category category);
    void deleteById(Long categoryId);

    /**************************/
    /* Method Advance */
    List<CategoryDto> findAllForUser();
    List<Category> findAllByNameOrDescription(String keyword);

}
