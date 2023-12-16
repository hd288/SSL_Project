package com.vn.ssl_be.course.application.serviceImpl;

import com.vn.ssl_be.common.exception.NotFoundException;
import com.vn.ssl_be.course.application.dto.CategoryDto;
import com.vn.ssl_be.course.application.service.CategoryService;
import com.vn.ssl_be.course.domain.model.Category;
import com.vn.ssl_be.course.domain.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) throws NotFoundException {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find Id!"));
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<CategoryDto> getCategoriesAndSize() {
        return categoryRepository.getCategoriesAndSize();
    }
}