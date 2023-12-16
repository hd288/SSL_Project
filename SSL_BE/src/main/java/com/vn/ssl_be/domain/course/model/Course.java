package com.vn.ssl_be.domain.course.model;
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
    private String courseId;

    @Column(name = "course_name", unique = true)
    private String courseName;

    @Column(name = "course_desc", nullable = false)
    private String courseDesc;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "is_actived", nullable = false)
    private boolean idActived;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons;
}
