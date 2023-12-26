package com.vn.ssl_be.domain.lesson.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vn.ssl_be.domain.course.model.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Long lessonId;

    @Column(name = "lesson_title", nullable = false)
    private String lessonTitle;

    @Column(name = "content_link", nullable = false, columnDefinition = "text")
    private String contentLink;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @JsonIgnoreProperties({"courseName", "courseDesc","duration","imageCourseUrl","category"})
    private Course course;

    @Column(name = "unit_score")
    private double unitScore;
}

