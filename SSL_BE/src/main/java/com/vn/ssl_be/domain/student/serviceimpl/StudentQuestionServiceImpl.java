package com.vn.ssl_be.domain.student.serviceimpl;

import com.vn.ssl_be.domain.lesson.dto.StudentQuestionRequest;
import com.vn.ssl_be.domain.lesson.repository.QuestionRepository;
import com.vn.ssl_be.domain.student.exception.StudentException;
import com.vn.ssl_be.domain.student.model.StudentQuestion;
import com.vn.ssl_be.domain.student.repository.StudentQuestionRepository;
import com.vn.ssl_be.domain.student.service.StudentQuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentQuestionServiceImpl implements StudentQuestionService {
    private final StudentQuestionRepository studentQuestionRepository;
    private final ModelMapper modelMapper;
    private final QuestionRepository questionRepository;



    @Override
    public List<StudentQuestion> save(List<StudentQuestionRequest> studentQuestionRequests) throws StudentException {
        List<StudentQuestion> studentQuestions = studentQuestionRequests.stream()
                .map(this::transferData)
                .map(studentQuestionRepository::save)
                .collect(Collectors.toList());
        return studentQuestions;
    }

    @Override
    public List<String> getStudentAnswersByLessonId(Long lessonId) {
        return studentQuestionRepository.getStudentAnswersByLessonId(lessonId);
    }

    @Override
    public double calculateScoreOfLesson(Long lessonId) {
        List<String> answerOfStudent = studentQuestionRepository.getStudentAnswersByLessonId(lessonId);
        List<String> correctAnswerList = questionRepository.getCorrectAnswersByLessonId(lessonId);

        int right = 0;
        int total = questionRepository.countByLessonId(lessonId);
        for (int i = 0; i < total; i++) {
            String correctAnswer = correctAnswerList.get(i);
            String studentAnswer = answerOfStudent.get(i);
            if (correctAnswer.equals(studentAnswer)) {
                right++;
            }
        }

        double score = ((double) right / total) * 10;
        return score;
    }

    @Override
    public void deleteStudentQuestionsByQuestion_Lesson_LessonId(Long lessonId) {
        studentQuestionRepository.deleteStudentQuestionsByQuestion_Lesson_LessonId(lessonId);
    }

    private StudentQuestion transferData(StudentQuestionRequest studentQuestionRequest) {
        StudentQuestion studentQuestion = modelMapper.map(studentQuestionRequest, StudentQuestion.class);
        return studentQuestion;
    }


}