package com.vn.ssl_be.domain.lesson.repository;

import com.vn.ssl_be.domain.lesson.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
        List<Question> findAllByLessonLessonId(Long lessonId);

        void deleteAllByLesson_LessonId(Long lessonId);

        @Query("SELECT COUNT(q) FROM Question q WHERE q.lesson.lessonId = :lessonId")
        int countByLessonId(Long lessonId);

        @Query("SELECT q.answer from Question q where q.lesson.lessonId = :lessonId")
        List<String> getCorrectAnswersByLessonId(Long lessonId);
}
