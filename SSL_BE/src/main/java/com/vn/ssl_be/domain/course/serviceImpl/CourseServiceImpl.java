package com.vn.ssl_be.domain.course.serviceImpl;

import com.vn.ssl_be.domain.course.dto.CourseDto;
import com.vn.ssl_be.domain.course.exception.CourseException;
import com.vn.ssl_be.domain.course.model.Course;
import com.vn.ssl_be.domain.course.repository.CourseRepository;
import com.vn.ssl_be.domain.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<CourseDto> allCourse() {
        return transferData(courseRepository.findAll());
    }

    @Override
    public Course findById(String id) throws CourseException {
        return courseRepository.findById(id)
                .orElseThrow(() -> CourseException.notFound("Could not find Id!"));
    }

    @Override
    public Course save(MultipartFile imageCourse, CourseDto course) {
        return null;
    }

    @Override
    public Course update(MultipartFile imageCourse, CourseDto course) {
        return null;
    }

    @Override
    public void deletedById(String id) {
        Course course = courseRepository.getById(id);
        course.setActived(false);
        courseRepository.save(course);
    }

    @Override
    public CourseDto getById(String id) throws CourseException {
        Course course = courseRepository.getById(id);
        if (course == null) {
            throw CourseException.notFound("Course not found with id: " + id);
        }
        return convertToDto(course);
    }

    @Override
    public List<CourseDto> searchCourse(String keyword) throws CourseException {
        List<Course> searchResults = courseRepository.searchCourse(keyword);
        if (searchResults.isEmpty()) {
            throw CourseException.notFound("No courses found matching the search criteria.");
        }
        return searchResults.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> findAllByCategory(String category) throws CourseException {
        List<Course> courses = courseRepository.findAllByCategory(category);
        if (courses.isEmpty()) {
            throw CourseException.notFound("No courses found in the specified category.");
        }
        return courses.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> findByCategoryId(Long id) throws CourseException {
        List<Course> courses = courseRepository.getCourseByCategoryId(id);
        if (courses.isEmpty()) {
            throw CourseException.notFound("No courses found in the specified category ID.");
        }
        return courses.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private List<CourseDto> transferData(List<Course> courses) {
        return courses.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CourseDto convertToDto(Course course) {
        return new CourseDto(
                course.getCourseId(),
                course.getCourseName(),
                course.getCourseDesc(),
                course.getImage(),
                course.getCategory(),
                course.getDuration(),
                course.getLessons()
        );
    }
}