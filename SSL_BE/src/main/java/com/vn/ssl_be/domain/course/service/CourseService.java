package com.vn.ssl_be.domain.course.service;

import com.vn.ssl_be.domain.course.dto.CourseDto;
import com.vn.ssl_be.domain.course.model.Course;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    List<CourseDto> allCourse();

    Course save(MultipartFile imageCourse, CourseDto course);

    Course update(MultipartFile imageCourse, CourseDto course);

    void deletedById(String id);

    CourseDto getById(String id);

    Course findById(String id);

    List<CourseDto> searchCourse(String keyword);

    List<CourseDto> findAllByCategory(String category);

    List<CourseDto> findByCategoryId(Long id);

}
