package com.vn.ssl_be.domain.lesson.serviceImpl;

import com.vn.ssl_be.domain.lesson.dto.QuestionRequest;
import com.vn.ssl_be.domain.lesson.dto.QuestionResponse;
import com.vn.ssl_be.domain.lesson.exception.LessonException;
import com.vn.ssl_be.domain.lesson.model.Question;
import com.vn.ssl_be.domain.lesson.repository.QuestionRepository;
import com.vn.ssl_be.domain.lesson.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    // solve
    @Override
    public List<QuestionResponse> findAllQuestions() {
        return findAll().stream()
                .map(question -> modelMapper.map(question, QuestionResponse.class))
                .collect(Collectors.toList());
    }

    // solve
    @Override
    public Question findById(Long id) throws LessonException {
        return questionRepository.findById(id).orElseThrow(() -> LessonException.notFound("Could not find with ID"));
    }

    //Method for admin page
    @Override
    public Question save(QuestionRequest questionRequest) throws LessonException {
        Question question = modelMapper.map(questionRequest, Question.class);
        return questionRepository.save(question);
    }

    @Override
    public void deletedById(Long id) throws LessonException {
        questionRepository.deleteById(id);
    }

    //get all by lessonId
    @Override
    public List<QuestionResponse> findAllByLessonLessonId(Long lessonId) {
        return questionRepository.findAllByLessonLessonId(lessonId).stream()
                .map(question -> modelMapper.map(question, QuestionResponse.class))
                .collect(Collectors.toList());
    }

    //delete all by lessonId
    @Override
    public void deleteAllByLesson_LessonId(Long lessonId) {
        questionRepository.deleteAllByLesson_LessonId(lessonId);
    }

    @Override
    public int countByLessonId(Long lessonId) {
        int numsOfQuestions = questionRepository.countByLessonId(lessonId);
        return numsOfQuestions;
    }

    @Override
    public List<String> getCorrectAnswersByLessonId(Long lessonId) {
       return questionRepository.getCorrectAnswersByLessonId(lessonId);
    }
}