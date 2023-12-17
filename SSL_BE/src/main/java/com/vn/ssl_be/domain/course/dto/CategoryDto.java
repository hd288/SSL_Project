package com.vn.ssl_be.domain.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Long categoryId;
    private String categoryName;
    private Long courseSize;
    private String description;
}
