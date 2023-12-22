package com.vn.ssl_be.controller;

import com.vn.ssl_be.common.util.PageResponseDto;
import com.vn.ssl_be.domain.course.dto.response.CourseResponse;
import com.vn.ssl_be.domain.course.model.Course;
import com.vn.ssl_be.domain.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class CourseWebController {
    private final CourseService courseService;

    //Show list courses for user(pageable)
    @GetMapping("/courses")
    public ResponseEntity<PageResponseDto<CourseResponse>> getCoursesForUser(Pageable pageable) {
        return new ResponseEntity<>(courseService.findAllCourseForUser(pageable), HttpStatus.OK);
    }
    //Show list courses when user research(pageable)
    @GetMapping("/courses/search")
    public ResponseEntity<PageResponseDto<CourseResponse>> getCoursesByNameOrDescForUser(@RequestParam("query") String keyword, Pageable pageable) {
        return new ResponseEntity<>(courseService.findAllCourseByNameOrDescriptionForUser(keyword, pageable), HttpStatus.OK);
    }
    //Show list courses in a category when user onclick
    @GetMapping("/courses/categories/{categoryId}")
    public ResponseEntity<List<CourseResponse>> getCoursesByCategoryIdForUser(@PathVariable Long categoryId) {
        return new ResponseEntity<>(courseService.findAllCourseByCategoryIdForUser(categoryId), HttpStatus.OK);
    }
    //Show course detail when user research
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Course> getCourseDetailByIdForUser(@PathVariable String courseId) {
        return new ResponseEntity<>(courseService.findById(courseId), HttpStatus.OK);
    }

//    @GetMapping("/menu")
//    public ResponseEntity<Map<String, Object>> getMenu() {
//        Map<String, Object> response = new HashMap<>();
//        List<Category> categories = categoryService.findAll();
//        List<Map<String, Object>> categoryCourseList = new ArrayList<>();
//
//        for (Category category : categories) {
//            Map<String, Object> categoryCourseMap = new HashMap<>();
//            categoryCourseMap.put("category", category);
//            List<CourseResponse> courses = courseService.findAllCourseForUser();
//            categoryCourseMap.put("courses", courses);
//            categoryCourseList.add(categoryCourseMap);
//        }
//        response.put("categories", categoryCourseList);
//        return ResponseEntity.ok(response);
//    }
}
