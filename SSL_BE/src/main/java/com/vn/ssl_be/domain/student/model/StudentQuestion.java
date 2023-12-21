package com.vn.ssl_be.domain.student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vn.ssl_be.domain.lesson.model.Answer;
import com.vn.ssl_be.domain.lesson.model.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_question")
public class StudentQuestion {
    @EmbeddedId
    @JsonIgnore
    private StudentQuestionId studentQuestionId;


    @Column(name = "student_answer", nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer studentAnswer;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Student student;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private Question question;
}