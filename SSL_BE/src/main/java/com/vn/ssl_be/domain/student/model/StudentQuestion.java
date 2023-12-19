package com.vn.ssl_be.domain.student.model;

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
    private StudentQuestionId studentQuestionId;

    @Column(name = "student_answer", nullable = false)
    private Answer studentAnswer;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private Student student;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    private Question question;
}