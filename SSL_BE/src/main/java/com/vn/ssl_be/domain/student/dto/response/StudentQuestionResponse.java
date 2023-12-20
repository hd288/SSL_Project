package com.vn.ssl_be.domain.student.dto.response;

import com.vn.ssl_be.domain.lesson.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQuestionResponse {
    private UUID userId;
    private Long questionId;
    private Answer studentAnswer;
}