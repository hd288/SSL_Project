package com.vn.ssl_be.domain.lesson.dto;

import com.vn.ssl_be.domain.lesson.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQuestionRequest {
    private String userId;
    private Long questionId;
    private Answer studentAnswer;
}
