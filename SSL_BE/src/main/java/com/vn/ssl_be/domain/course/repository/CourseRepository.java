package com.vn.ssl_be.domain.course.repository;

import com.vn.ssl_be.domain.course.model.Category;
import com.vn.ssl_be.domain.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course, String> {

//        @Query("select cr from Course cr where cr.isActived = true")
//        List<Course> getAllCourse();

//        @Query("select cr from Course cr inner join Category c on c.categoryId = cr.category.categoryId")
//        List<Course> findAllByCategory(String category);

//        @Query("select cr from Course cr inner join Category c on c.categoryId = ?1 where cr.isActived = true")
//        List<Course> getCourseByCategoryId(Long id);

//        @Query("select cr from Course cr where cr.courseName like %?1% or cr.courseDesc like %?1%")
//        List<Course> searchCourse(String keyword);

        /* Logic CourseWebUser */
        List<Course> findAllByCategory(Category category);
        List<Course> findAllByCourseNameContainingOrCourseDescContaining(String courseName, String courseDesc);

}
