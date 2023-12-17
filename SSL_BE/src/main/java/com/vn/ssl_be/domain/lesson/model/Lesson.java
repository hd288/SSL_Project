package com.vn.ssl_be.domain.lesson.model;

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

    @Column(name = "content_link", nullable = false)
    private String contentLink;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

    @Column(name = "unit_score")
    private double unitScore;
}

