package com.vn.ssl_be.domain.course.dto.response;

import com.vn.ssl_be.domain.course.model.Category;
import com.vn.ssl_be.domain.lesson.model.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDetailResponseV1 {
    private String courseId;
    private String courseName;
    private String courseTitle;
    private String courseDesc;
    private int duration;
    private String categoryName;
    private List<LessonResponse> lessons;
    private String imageCourseUrl;
}
