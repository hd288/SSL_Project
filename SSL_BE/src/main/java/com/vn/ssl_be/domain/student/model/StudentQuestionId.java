package com.vn.ssl_be.domain.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Setter
public class StudentQuestionId implements Serializable {
    @Column(name = "user_id")
    private String userId;

    @Column(name = "question_id")
    private Long questionId;
}
