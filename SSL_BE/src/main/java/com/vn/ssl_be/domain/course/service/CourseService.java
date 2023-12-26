package com.vn.ssl_be.domain.course.service;

import com.vn.ssl_be.common.util.PageResponseDto;
import com.vn.ssl_be.domain.course.dto.request.CourseRequest;
import com.vn.ssl_be.domain.course.dto.response.CourseResponse;
import com.vn.ssl_be.domain.course.dto.response.PageResponseDtoV2;
import com.vn.ssl_be.domain.course.exception.CourseException;
import com.vn.ssl_be.domain.course.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    /* 4 Method Basic */
    PageResponseDto<Course> findAll(Pageable pageable);
    PageResponseDtoV2<CourseResponse> getCourses(Integer page);

    Course findById(String id) throws CourseException;

    Course save(CourseRequest courseRequest);

    void deletedById(String id);

    /**************************/
    /* Method Advance */
    PageResponseDto<Course> findAllCourseByNameOrDescription(String keyword, Pageable pageable);
    PageResponseDto<CourseResponse> findAllCourseForUser(Pageable pageable);
    PageResponseDto<CourseResponse> findAllCourseByNameOrDescriptionForUser(String keyword, Pageable pageable);
    List<CourseResponse> findAllCourseByCategoryIdForUser(Long categoryId);

}
