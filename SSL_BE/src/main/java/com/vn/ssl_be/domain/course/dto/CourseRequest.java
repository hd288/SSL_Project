package com.vn.ssl_be.domain.course.dto;

import com.vn.ssl_be.domain.course.model.Category;
import com.vn.ssl_be.domain.lesson.model.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    private String courseId;
    private String courseName;
    private String courseDesc;
    private int duration;
    private Category category;
    private List<Lesson> lessons;
    private MultipartFile fileImageCourse;
}
