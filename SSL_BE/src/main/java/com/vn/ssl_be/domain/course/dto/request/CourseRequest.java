package com.vn.ssl_be.domain.course.dto.request;

import com.vn.ssl_be.domain.course.model.Category;
import com.vn.ssl_be.domain.lesson.model.Lesson;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @NotNull
    private String courseName;
    @NotNull
    private String courseTitle;
    @NotNull
    private String courseDesc;
    @NotNull
    private Integer duration;
    private MultipartFile fileImageCourse;
    private Boolean isActived;
    private Category category;
}
