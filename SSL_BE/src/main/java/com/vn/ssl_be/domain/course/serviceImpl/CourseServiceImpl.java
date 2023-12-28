package com.vn.ssl_be.domain.course.serviceImpl;

import com.vn.ssl_be.common.exception.DomainException;
import com.vn.ssl_be.common.util.PageResponseDto;
import com.vn.ssl_be.common.util.UploadService;
import com.vn.ssl_be.domain.course.dto.request.CourseRequest;
import com.vn.ssl_be.domain.course.dto.response.CourseDetailResponseV1;
import com.vn.ssl_be.domain.course.dto.response.CourseResponse;
import com.vn.ssl_be.domain.course.dto.response.LessonResponse;
import com.vn.ssl_be.domain.course.dto.response.PageResponseDtoV1;
import com.vn.ssl_be.domain.course.exception.CourseException;
import com.vn.ssl_be.domain.course.model.Category;
import com.vn.ssl_be.domain.course.model.Course;
import com.vn.ssl_be.domain.course.repository.CategoryRepository;
import com.vn.ssl_be.domain.course.repository.CourseRepository;
import com.vn.ssl_be.domain.course.service.CategoryService;
import com.vn.ssl_be.domain.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;
    private final UploadService uploadService;
    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    /* 4 Method Basic */
    @Override
    public PageResponseDto<Course> findAll(Pageable pageable) {
        Page<Course> page = courseRepository.findAll(pageable);

        return PageResponseDto.<Course>builder()
                .data(page.getContent())
                .totalPage(page.getTotalPages())
                .pageNumber(page.getTotalPages())
                .size(8)
                .sort(page.getSort().toString()).build();
    }

    @Override
    public PageResponseDtoV1<CourseResponse> getCourses(Integer page) {
        List<CourseResponse> data = new ArrayList<>();
        List<CourseResponse> courseResponses = courseRepository.findAll().stream().map(course -> {
                CourseResponse courseResponse = modelMapper.map(course, CourseResponse.class);
                    return courseResponse;
        }).toList();

        int pageSize = 8;
        int end = 0;
        int pageNumber = 1;

        if (page != null) {
            end = pageSize * page;
            pageNumber = page;
        }else  {
            end =  pageSize;
        }

        int start =  end - pageSize;
        int totalPage = (courseResponses.size() / pageSize) + 1;

        if(end > courseResponses.size()) {
            end = courseResponses.size();
        }

        for (int i = start; i < end; i++) {
            data.add(courseResponses.get(i));
        }

        PageResponseDtoV1<CourseResponse> pageResponseDto =  new PageResponseDtoV1<>();
        pageResponseDto.setTotalPage(totalPage);
        pageResponseDto.setData(data);
        pageResponseDto.setSize(8);
        pageResponseDto.setPageNumber(pageNumber);
        pageResponseDto.setSort(null);

        return pageResponseDto;
    }

    @Override
    public CourseDetailResponseV1 getCourseDetail(String courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> DomainException.notFound(courseId));

        return CourseDetailResponseV1.builder()
                .courseId(course.getCourseId())
                .courseName(course.getCourseName())
                .courseTitle(course.getCourseTitle())
                .courseDesc(course.getCourseDesc())
                .duration(course.getDuration())
                .imageCourseUrl(course.getImageCourseUrl())
                .lessons(course.getLessons().stream().map(lesson -> {
                            return LessonResponse.builder()
                                    .lessonId(lesson.getLessonId())
                                    .lessonTitle(lesson.getLessonTitle())
                                    .contentLink(lesson.getContentLink())
                                    .build();
                        }).toList()
                )
                .build();
    }



    @Override
    public Course findById(String id) throws CourseException {
        return courseRepository.findById(id)
                .orElseThrow(() -> CourseException.notFound("Could not find Id!"));
    }

    @Override
    public Course save(CourseRequest courseRequest) {
        String imageCourseUrl;
        if (courseRequest.getCourseId() == null) {
            courseRequest.setIsActived(true);
            imageCourseUrl = null;
        } else {
            imageCourseUrl = courseRepository.findById(courseRequest.getCourseId()).orElse(new Course()).getImageCourseUrl();
        }

        if (courseRequest.getFileImageCourse() != null) {
            imageCourseUrl = (uploadService.uploadFile(courseRequest.getFileImageCourse()));
        }
        Course course = modelMapper.map(courseRequest, Course.class);
        course.setImageCourseUrl(imageCourseUrl);

        try {
            return courseRepository.save(course);
        } catch (DataIntegrityViolationException e) {
            throw CourseException.duplicateName("Duplicated");
        }
    }


    @Override
    public void deletedById(String id) {
        courseRepository.deleteById(id);
    }

    /*************************************************************/
    /* Method Advance */

    @Override
    public PageResponseDto<Course> findAllCourseByNameOrDescription(String keyword, Pageable pageable) {
        Page<Course> searchResults = courseRepository.findAllByCourseNameContainingOrCourseDescContaining(keyword, keyword, pageable);
        if (searchResults.getContent().isEmpty()) {
            throw CourseException.notFound("No courses found matching the search criteria.");
        };

        return PageResponseDto.<Course>builder()
                .data(searchResults.getContent())
                .totalPage(searchResults.getTotalPages())
                .pageNumber(searchResults.getNumber())
                .size(searchResults.getSize())
                .sort(searchResults.getSort().toString()).build();
    }

    @Override
    public PageResponseDto<CourseResponse> findAllCourseForUser(Pageable pageable) {
        Page<Course> page = courseRepository.findAll(pageable);

        List<CourseResponse> list = page.getContent().stream()
                .map(course -> {
                    CourseResponse courseResponse = modelMapper.map(course, CourseResponse.class);
                    courseResponse.setCategoryName(course.getCategory().getCategoryName());
                    return courseResponse;
                }).collect(Collectors.toList());

        return PageResponseDto.<CourseResponse>builder()
                .data(list)
                .totalPage(page.getTotalPages())
                .pageNumber(page.getNumber())
                .size(page.getSize())
                .sort(page.getSort().toString()).build();

    }

    @Override
    public PageResponseDto<CourseResponse> findAllCourseByNameOrDescriptionForUser(String keyword, Pageable pageable) throws CourseException {
        Page<Course> searchResults = courseRepository.findAllByCourseNameContainingOrCourseDescContaining(keyword, keyword, pageable);
        if (searchResults.getContent().isEmpty()) {
            throw CourseException.notFound("No courses found matching the search criteria.");
        }
        List<CourseResponse> list = searchResults.getContent().stream()
                .map(course -> {
                    CourseResponse courseResponse = modelMapper.map(course, CourseResponse.class);
                    courseResponse.setCategoryName(course.getCategory().getCategoryName());
                    return courseResponse;
                }).collect(Collectors.toList());

        return PageResponseDto.<CourseResponse>builder()
                .data(list)
                .totalPage(searchResults.getTotalPages())
                .pageNumber(searchResults.getNumber())
                .size(searchResults.getSize())
                .sort(searchResults.getSort().toString()).build();
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
//    private List<CourseResponse> transferData(List<Course> courses) {
//        return courses.stream()
//                .map(this::convertToDto)
//                .collect(Collectors.toList());
//    }
//
//    private CourseResponse convertToDto(Course course) {
//        return new CourseResponse(
//                course.getCourseId(),
//                course.getCourseName(),
//                course.getDuration(),
//                course.getCategory(),
//                course.getImageCourseUrl()
//        );
//    }
}