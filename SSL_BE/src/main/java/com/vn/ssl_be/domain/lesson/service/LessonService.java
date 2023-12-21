package com.vn.ssl_be.domain.lesson.service;

import com.vn.ssl_be.domain.lesson.dto.request.LessonRequest;
import com.vn.ssl_be.domain.lesson.exception.LessonException;
import com.vn.ssl_be.domain.lesson.model.Lesson;

import java.util.List;

public interface LessonService{
    /* 4 Method Basic */
    List<Lesson> findAll();
    Lesson findById(Long lessonId) throws LessonException;
    Lesson save (LessonRequest lessonRequest);
    void deleteById(Long lessonId);

    /**************************/
    /* Method Advance */
    List<Lesson> findAllLessonByCourseId(String courseId);
    List<Lesson> findAllCourseByTitle(String keyword);
}
