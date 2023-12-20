package com.vn.ssl_be.domain.course.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
    private Long categoryId;
    @NotBlank
    private String categoryName;
    @NotBlank
    private String description;
}
