package com.vn.ssl_be.domain.lesson.dto;

import com.vn.ssl_be.domain.course.model.Course;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequest {
    private Long lessonId;
    @NotNull
    private String lessonTitle;

    private MultipartFile fileContentPDF;

    private Course course;
}
