package com.vn.ssl_be.domain.lesson.dto;

import com.vn.ssl_be.domain.course.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequest {
    private Long lessonId;

    private MultipartFile fileContentPDF;

    private Course course;
}
