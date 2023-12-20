package com.vn.ssl_be.domain.student.repository;

import com.vn.ssl_be.domain.student.model.StudentQuestion;
import com.vn.ssl_be.domain.student.model.StudentQuestionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface StudentQuestionRepository extends JpaRepository<StudentQuestion, StudentQuestionId> {
    List<StudentQuestion> findByStudent_UserId(UUID userId);

    List<StudentQuestion> findByQuestion_Lesson_LessonId(Long lessonId);

    double calculateScoreByLessonId(Long lessonId);
}
