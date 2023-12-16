package com.vn.ssl_be.domain.course.repository;

import com.vn.ssl_be.domain.course.dto.CategoryDto;
import com.vn.ssl_be.domain.course.model.Category;
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

    @Query(value = "SELECT new com.vn.ssl_be.domain.course.dto.CategoryDto(c.categoryId, c.categoryName, count (cr.category.categoryId), c.description)" +
            "from Category c left join Course cr on c.categoryId = cr.category.categoryId " +
            "where cr.idActived=true " +
            "group by c.categoryId")
    List<CategoryDto> getCategoriesAndSize();

}
