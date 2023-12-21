package com.vn.ssl_be.domain.student.service;

import com.vn.ssl_be.domain.lesson.dto.StudentQuestionRequest;
import com.vn.ssl_be.domain.student.exception.StudentException;
import com.vn.ssl_be.domain.student.model.StudentQuestion;

import java.util.List;

public interface StudentQuestionService {

     List<StudentQuestion> save(List<StudentQuestionRequest> studentQuestionRequests) throws StudentException;

     List<String> getStudentAnswersByLessonId(Long lessonId);

     double calculateScoreOfLesson(Long lessonId);

     void deleteStudentQuestionsByQuestion_Lesson_LessonId(Long lessonId);
}
