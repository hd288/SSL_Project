package com.vn.ssl_be.domain.course.serviceImpl;

import com.vn.ssl_be.common.util.PageResponseDto;
import com.vn.ssl_be.domain.course.dto.request.CategoryRequest;
import com.vn.ssl_be.domain.course.dto.response.CategoryResponse;
import com.vn.ssl_be.domain.course.exception.CourseException;
import com.vn.ssl_be.domain.course.service.CategoryService;
import com.vn.ssl_be.domain.course.model.Category;
import com.vn.ssl_be.domain.course.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;


    /* 4 Method Basic */
    @Override
    public PageResponseDto<Category> findAll(Pageable pageable) {

        Page<Category> page = categoryRepository.findAll(pageable);
        return PageResponseDto.<Category>builder()
                .data(page.getContent())
                .totalPage(page.getTotalPages())
                .pageNumber(page.getNumber())
                .size(page.getSize())
                .sort(page.getSort().toString()).build();
    }

    @Override
    public Category findById(Long id) throws CourseException {
        return categoryRepository.findById(id)
                .orElseThrow(() -> CourseException.notFound("Could not find Id!"));
    }

    @Override
    public Category save(CategoryRequest categoryRequest) {
        Category category = modelMapper.map(categoryRequest, Category.class);
        try {
            return categoryRepository.save(category);
        } catch (DataIntegrityViolationException e) {
            throw CourseException.duplicateName("Duplicated");
        }
    }

    @Override
    public void deleteById(Long id) {

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        categoryRepository.deleteById(id);
    }



    /*************************************************************/
    @Override
    public List<Category> findAllCategoryByNameOrDescription(String keyword) throws CourseException {
        List<Category> searchResults = categoryRepository.findAllByCategoryNameContainingOrDescriptionContaining(keyword, keyword);
        if (searchResults.isEmpty()) {
            throw CourseException.notFound("No categories found matching the search criteria.");
        }
        return searchResults;
    }
    /* Method Advance */
    @Override
    public List<CategoryResponse> getCategoriesAndQuantityCourses() {
        return categoryRepository.getCategoriesAndQuantityCourses();
    }
}