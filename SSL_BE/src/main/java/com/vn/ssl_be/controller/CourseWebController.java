package com.vn.ssl_be.controller;

import com.vn.ssl_be.domain.course.dto.CategoryDto;
import com.vn.ssl_be.domain.course.dto.CourseResponse;
import com.vn.ssl_be.domain.course.model.Category;
import com.vn.ssl_be.domain.course.model.Course;
import com.vn.ssl_be.domain.course.service.CategoryService;
import com.vn.ssl_be.domain.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class CourseWebController {
    private final CourseService courseService;
    private final CategoryService categoryService;

    //Show List Categories For User
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getQuestions() {
        return new ResponseEntity<>(categoryService.findAllForUser(),HttpStatus.OK);
    }

    //Show List Course For User
    @GetMapping("/courses")
    public ResponseEntity<List<CourseResponse>> getCourses() {
        return new ResponseEntity<>(courseService.findAllForUser(),HttpStatus.OK);
    }

    //Show Result Search Course For User
    @GetMapping("/courses/search")
    public ResponseEntity<List<CourseResponse>> searchCourses(@RequestParam("search") String keyword) {
        return new ResponseEntity<>(courseService.findAllByNameOrDescription(keyword),HttpStatus.OK);
    }

    //Show the courses in a category when onClick
    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<List<CourseResponse>> getCoursesByCategoryId(@PathVariable Long categoryId) {
        return new ResponseEntity<>(courseService.findAllByCategoryId(categoryId),HttpStatus.OK);
    }
    //Show detail course when onClick
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Course> getCourseDetail(@PathVariable String courseId) {
        return new ResponseEntity<>(courseService.findById(courseId),HttpStatus.OK);
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
