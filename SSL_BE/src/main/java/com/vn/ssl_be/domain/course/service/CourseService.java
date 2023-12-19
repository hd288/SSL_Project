package com.vn.ssl_be.domain.course.service;

import com.vn.ssl_be.domain.course.dto.CourseRequest;
import com.vn.ssl_be.domain.course.dto.CourseResponse;
import com.vn.ssl_be.domain.course.exception.CourseException;
import com.vn.ssl_be.domain.course.model.Course;

import java.util.List;

public interface CourseService {
    /* 4 Method Basic */
    List<Course> findAll();

    Course findById(String id) throws CourseException;

    Course save(CourseRequest courseRequest);

    void deletedById(String id);

    /**************************/
    /* Method Advance */
    List<CourseResponse> findAllForUser();
    List<CourseResponse> findAllByNameOrDescription(String keyword);
    List<CourseResponse> findAllByCategoryId(Long categoryId);

}
