package com.vn.ssl_be.domain.course.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vn.ssl_be.domain.course.model.Category;
import com.vn.ssl_be.domain.lesson.model.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
