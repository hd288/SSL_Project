package com.vn.ssl_be.mentor.domain.model;

import com.vn.ssl_be.course.domain.model.Course;
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
