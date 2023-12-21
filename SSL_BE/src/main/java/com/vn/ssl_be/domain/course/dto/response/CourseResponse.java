package com.vn.ssl_be.domain.course.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String courseTitle;
    private int duration;
//    @JsonIgnoreProperties({"categoryId","description"})
//    private Category category;
    private String categoryName;
    private String imageCourseUrl;
}
