package com.vn.ssl_be.domain.course.serviceImpl;

import com.vn.ssl_be.common.util.UploadService;
import com.vn.ssl_be.domain.course.dto.CourseRequest;
import com.vn.ssl_be.domain.course.dto.CourseResponse;
import com.vn.ssl_be.domain.course.exception.CourseException;
import com.vn.ssl_be.domain.course.model.Category;
import com.vn.ssl_be.domain.course.model.Course;
import com.vn.ssl_be.domain.course.repository.CourseRepository;
import com.vn.ssl_be.domain.course.service.CategoryService;
import com.vn.ssl_be.domain.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;
    private final UploadService uploadService;
    private final CategoryService categoryService;

    /* 4 Method Basic */
    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(String id) throws CourseException {
        return courseRepository.findById(id)
                .orElseThrow(() -> CourseException.notFound("Could not find Id!"));
    }

    @Override
    public Course save(CourseRequest courseRequest) {
        if(courseRequest.getCourseId()==null){
            courseRequest.setIsActived(true);
        }
        String imageCourseUrl = null;
        if (!courseRequest.getFileImageCourse().isEmpty()) {
            imageCourseUrl = (uploadService.uploadFileImage(courseRequest.getFileImageCourse()));
        }
        Course course = modelMapper.map(courseRequest, Course.class);
        course.setImageCourseUrl(imageCourseUrl);
        return courseRepository.save(course);
    }


    @Override
    public void deletedById(String id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> findAllCourseByNameOrDescription(String keyword) {
        List<Course> searchResults = courseRepository.findAllByCourseNameContainingOrCourseDescContaining(keyword, keyword);
        if (searchResults.isEmpty()) {
            throw CourseException.notFound("No courses found matching the search criteria.");
        };
        return searchResults;
    }

    /*************************************************************/
    /* Method Advance */
    @Override
    public List<CourseResponse> findAllCourseForUser() {
        return findAll().stream()
                .map(course -> modelMapper.map(course, CourseResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseResponse> findAllCourseByNameOrDescriptionForUser(String keyword) throws CourseException {
        List<Course> searchResults = courseRepository.findAllByCourseNameContainingOrCourseDescContaining(keyword, keyword);
        if (searchResults.isEmpty()) {
            throw CourseException.notFound("No courses found matching the search criteria.");
        }
        return searchResults.stream()
                .map(course -> modelMapper.map(course, CourseResponse.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<CourseResponse> findAllCourseByCategoryIdForUser(Long id) throws CourseException {
        Category category = categoryService.findById(id);
        List<Course> courses = courseRepository.findAllByCategory(category);
        if (courses.isEmpty()) {
            throw CourseException.notFound("No courses found in the specified category ID.");
        }
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseResponse.class))
                .collect(Collectors.toList());
    }


    /*************************************************************/
    /* Create your own mapper method*/ /* But now we are supported by Modermapper*/
    private List<CourseResponse> transferData(List<Course> courses) {
        return courses.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CourseResponse convertToDto(Course course) {
        return new CourseResponse(
                course.getCourseId(),
                course.getCourseName(),
                course.getDuration(),
                course.getCategory(),
                course.getImageCourseUrl()
        );
    }
}