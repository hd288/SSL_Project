package com.vn.ssl_be.domain.course.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name = "category_name", unique = true)
    private String categoryName;

    @Column(name = "description", nullable = false, columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Course> courses;
}
