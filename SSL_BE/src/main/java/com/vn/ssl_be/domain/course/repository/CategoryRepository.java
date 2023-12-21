package com.vn.ssl_be.domain.course.repository;

import com.vn.ssl_be.domain.course.dto.response.CategoryResponse;
import com.vn.ssl_be.domain.course.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByCategoryNameContainingOrDescriptionContaining(String categoryName, String description);

    @Query(value = "SELECT new com.vn.ssl_be.domain.course.dto.response.CategoryResponse(c.categoryId, c.categoryName, count (cr.courseId), c.description)" +
            "from Category c left join Course cr on c.categoryId = cr.category.categoryId " +
            "where cr.isActived=true " +
            "group by c.categoryId")
    List<CategoryResponse> getCategoriesAndQuantityCourses();

}
