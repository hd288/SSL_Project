package com.vn.ssl_be.domain.course.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    private String courseId;
    private String courseName;
    private String courseDesc;
    @NotNull
    private Integer duration;
    private MultipartFile fileImageCourse;
    private Boolean isActived;
    private Category category;
}
