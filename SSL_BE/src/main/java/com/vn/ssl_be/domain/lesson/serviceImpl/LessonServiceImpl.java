package com.vn.ssl_be.domain.lesson.serviceImpl;

import com.vn.ssl_be.common.util.UploadService;
import com.vn.ssl_be.domain.course.exception.CourseException;
import com.vn.ssl_be.domain.course.model.Course;
import com.vn.ssl_be.domain.course.repository.CourseRepository;
import com.vn.ssl_be.domain.lesson.dto.request.LessonRequest;
import com.vn.ssl_be.domain.lesson.exception.LessonException;
import com.vn.ssl_be.domain.lesson.repository.LessonRepository;
import com.vn.ssl_be.domain.lesson.service.LessonService;
import com.vn.ssl_be.domain.lesson.model.Lesson;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final UploadService uploadService;
    private final ModelMapper modelMapper;
    private final CourseRepository courseRepository;

    /* 4 Method Basic */
    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson findById(Long lessonId) throws LessonException {
        return lessonRepository.findById(lessonId)
                .orElseThrow(() -> LessonException.notFound("Could not find Id!")
        );
    }

    @Override
    public Lesson save(LessonRequest lessonRequest) {
        String contentLink;
        if(lessonRequest.getLessonId()==null){
            contentLink= null;
        }else {
            contentLink = lessonRepository.findById(lessonRequest.getLessonId()).orElse(new Lesson()).getContentLink();
        }

        if(lessonRequest.getFileContentPDF()!=null){
            contentLink = uploadService.uploadFile(lessonRequest.getFileContentPDF());
        }


        Lesson lesson = modelMapper.map(lessonRequest, Lesson.class);
        lesson.setContentLink(contentLink);
        try {
            return lessonRepository.save(lesson);
        } catch (DataIntegrityViolationException e) {
            throw LessonException.duplicateName("Duplicated");
        }
    }

    @Override
    public void deleteById(Long lessonId) {
        lessonRepository.deleteById(lessonId);
    }

    @Override
    public List<Lesson> findAllLessonByCourseId(String courseId) throws LessonException {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> LessonException.notFound("Could not found id")
                );
        return lessonRepository.findAllByCourse(course);
    }

    @Override
    public List<Lesson> findAllLessonByTitle(String keyword) {
        List<Lesson> searchResults = lessonRepository.findAllByLessonTitleContaining(keyword);
        if (searchResults.isEmpty()) {
            throw CourseException.notFound("No lessons found matching the search criteria.");
        }
        return searchResults;
    }

}
