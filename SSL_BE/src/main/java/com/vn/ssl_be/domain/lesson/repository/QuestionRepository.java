package com.vn.ssl_be.domain.lesson.repository;

import com.vn.ssl_be.domain.lesson.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

        List<Question> findAllByLessonLessonId(Long lessonId);

        void deleteAllByLesson_LessonId(Long lessonId);

}
