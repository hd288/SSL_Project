package com.vn.ssl_be.domain.course.dto;

import com.vn.ssl_be.domain.course.model.Category;
import com.vn.ssl_be.domain.lesson.model.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private String courseId;
    private String courseName;
    private String courseDesc;
    private int duration;
    private Category category;
    private List<Lesson> lessons;
    private String image;

    public CourseDto(String courseId, String courseName, String courseDesc, String image, Category category, int duration, List<Lesson> lessons) {
    }
}