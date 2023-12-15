package com.vn.ssl_be.student.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class StudentQuestionId implements Serializable {
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "question_id")
    private Long questionId;
}
