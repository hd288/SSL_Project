package com.vn.ssl_be.domain.mentor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mentor_course")
public class MentorCourse {
    @EmbeddedId
    private MentorCourseId mentorCourseId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private Mentor mentor;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;
}
