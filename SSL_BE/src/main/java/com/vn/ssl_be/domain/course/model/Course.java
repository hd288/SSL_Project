package com.vn.ssl_be.domain.course.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vn.ssl_be.domain.lesson.model.Lesson;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String courseId;

    @Column(name = "course_name", unique = true, nullable = false)
    private String courseName;

    @Column(name = "course_desc", nullable = false, columnDefinition = "text")
    private String courseDesc;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String imageCourseUrl;

    @Column(name = "is_activated", nullable = false)
    private boolean isActived;


    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @JsonIgnoreProperties({"categoryName","description"})
    private Category category;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Lesson> lessons;
}
