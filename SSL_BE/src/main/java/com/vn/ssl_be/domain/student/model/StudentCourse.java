package com.vn.ssl_be.domain.student.model;

import com.vn.ssl_be.domain.course.model.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_course")
public class StudentCourse {
    @Id
    @Column(name = "student_course_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentCourseId;

    @Column(name = "course_price")
    private Long coursePrice;

    @Column(name = "register_date")
    @Temporal(TemporalType.DATE)
    private Date registerDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "course_score")
    private Integer courseScore;
}
