package com.vn.ssl_be.domain.course.service;

import com.vn.ssl_be.common.util.PageResponseDto;
import com.vn.ssl_be.domain.course.dto.request.CategoryRequest;
import com.vn.ssl_be.domain.course.dto.response.CategoryResponse;
import com.vn.ssl_be.domain.course.exception.CourseException;
import com.vn.ssl_be.domain.course.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface CategoryService {
    /* 4 Method Basic */
    PageResponseDto<Category> findAll(Pageable pageable);
    Category findById(Long categoryId) throws CourseException;
    Category save (CategoryRequest categoryRequest);
    void deleteById(Long categoryId);

    /**************************/
    /* Method Advance */
    List<Category> findAllCategoryByNameOrDescription(String keyword);
    List<CategoryResponse> getCategoriesAndQuantityCourses();
}
