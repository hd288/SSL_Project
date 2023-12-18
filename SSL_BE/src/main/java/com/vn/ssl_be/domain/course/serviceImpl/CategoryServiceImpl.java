package com.vn.ssl_be.domain.course.serviceImpl;

import com.vn.ssl_be.domain.course.dto.CategoryDto;
import com.vn.ssl_be.domain.course.exception.CourseException;
import com.vn.ssl_be.domain.course.service.CategoryService;
import com.vn.ssl_be.domain.course.model.Category;
import com.vn.ssl_be.domain.course.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    /* 4 Method Basic */
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) throws CourseException {
        return categoryRepository.findById(id)
                .orElseThrow(() -> CourseException.notFound("Could not find Id!"));
    }

    @Override
    public Category save(Category category) {
        try {
            return categoryRepository.save(category);
        } catch (DataIntegrityViolationException e) {
            throw CourseException.duplicateName("Duplicated");
        }
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }



    /*************************************************************/
    @Override
    public List<CategoryDto> findAllCategoryByNameOrDescription(String keyword) throws CourseException {
        List<Category> searchResults = categoryRepository.findAllByCategoryNameContainingOrDescriptionContaining(keyword, keyword);
        if (searchResults.isEmpty()) {
            throw CourseException.notFound("No courses found matching the search criteria.");
        }
        return searchResults.stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }
    /* Method Advance */
    @Override
    public List<CategoryDto> getCategoriesAndQuantityCourses() {
        return categoryRepository.getCategoriesAndQuantityCourses();
    }
}