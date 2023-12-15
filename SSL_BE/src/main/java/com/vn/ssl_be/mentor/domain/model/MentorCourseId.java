package com.vn.ssl_be.mentor.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;
@Embeddable
public class MentorCourseId implements Serializable {
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "course_id")
    private String courseId;
}
