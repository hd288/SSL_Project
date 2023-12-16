package com.vn.ssl_be.course.domain.repository;

import com.vn.ssl_be.course.application.dto.CategoryDto;
import com.vn.ssl_be.course.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("UPDATE Category c SET c.categoryName = :categoryName, c.description = :description WHERE c.categoryId = :categoryId")
    void updateCategory(Long categoryId, String categoryName, String description);

    @Query(value = "SELECT new com.vn.ssl_be.course.application.dto.CategoryDto(c.categoryId, c.categoryName, count (cr.category.categoryId), c.description)" +
            "from Category c left join Course cr on c.categoryId = cr.category.categoryId " +
            "where cr.idActived=true " +
            "group by c.categoryId")
    List<CategoryDto> getCategoriesAndSize();
}
