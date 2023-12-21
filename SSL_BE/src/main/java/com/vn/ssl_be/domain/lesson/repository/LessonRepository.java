package com.vn.ssl_be.domain.lesson.repository;

import com.vn.ssl_be.domain.course.model.Course;
import com.vn.ssl_be.domain.lesson.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findAllByCourse (Course course);

    List<Lesson> findAllByLessonTitleContaining (String keyword);
}
