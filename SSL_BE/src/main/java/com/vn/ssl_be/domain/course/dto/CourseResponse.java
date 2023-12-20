package com.vn.ssl_be.domain.course.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
    private String courseId;
    private String courseName;
    private int duration;
    @JsonIgnoreProperties({"categoryName","description"})
    private Category category;
    private String imageCourseUrl;
}
