package com.vn.ssl_be.domain.course.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name = "category_name", unique = true)
    private String categoryName;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Course> courses;
}
