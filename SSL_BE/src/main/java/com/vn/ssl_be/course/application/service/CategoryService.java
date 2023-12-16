package com.vn.ssl_be.course.application.service;

import com.vn.ssl_be.common.exception.NotFoundException;
import com.vn.ssl_be.course.application.dto.CategoryDto;
import com.vn.ssl_be.course.domain.model.Category;

import java.util.List;
public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id) throws NotFoundException;
    Category save (Category category);
    void deleteById(Long id);
    Category update(Category category);
    List<CategoryDto> getCategoriesAndSize();
}
