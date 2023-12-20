package com.vn.ssl_be.domain.lesson.service;

import com.vn.ssl_be.domain.course.dto.CategoryRequest;
import com.vn.ssl_be.domain.course.dto.CourseResponse;
import com.vn.ssl_be.domain.course.exception.CourseException;
import com.vn.ssl_be.domain.course.model.Category;
import com.vn.ssl_be.domain.lesson.dto.LessonRequest;
import com.vn.ssl_be.domain.lesson.model.Lesson;

import java.util.List;

public interface LessonService{
    /* 4 Method Basic */
    List<Lesson> findAll();
    Lesson findById(Long lessonId) throws CourseException;
    Lesson save (LessonRequest lessonRequest);
    void deleteById(Long lessonId);

    /**************************/
    /* Method Advance */
    List<Lesson> findAllLessonByCourseId(String courseId);
}
