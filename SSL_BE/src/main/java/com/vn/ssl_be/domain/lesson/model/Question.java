package com.vn.ssl_be.domain.lesson.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "question_text", nullable = false, columnDefinition = "text")
    private String questionText;

    @Column(name = "answer", nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer answer;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lesson_id", referencedColumnName = "lesson_id")
    @JsonIgnoreProperties("{contentLink, course, unitScore, questions}")
    private Lesson lesson;

    @Column(nullable = false)
    private String optionA;
    @Column(nullable = false)
    private String optionB;
    @Column(nullable = false)
    private String optionC;
    @Column(nullable = false)
    private String optionD;
}
