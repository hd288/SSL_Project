package com.vn.ssl_be.domain.course.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private Long categoryId;
    private String categoryName;
    private Long courseQuantity;
    private String description;

}
