package com.vn.ssl_be.domain.course.dto;

import com.vn.ssl_be.domain.course.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
    private String courseId;
    private String courseName;
    private String courseDesc;
    private int duration;
    private Category category;
    private String imageCourseUrl;
}
