package com.vn.ssl_be.domain.student.repository;

import com.vn.ssl_be.domain.student.model.StudentQuestion;
import com.vn.ssl_be.domain.student.model.StudentQuestionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface StudentQuestionRepository extends JpaRepository<StudentQuestion, StudentQuestionId> {
    @Query("select sq.studentAnswer from StudentQuestion sq where sq.question.lesson.lessonId = :lessonId")
    List<String> getStudentAnswersByLessonId(Long lessonId);

    void deleteStudentQuestionsByQuestion_Lesson_LessonId(Long lessonId);
}
