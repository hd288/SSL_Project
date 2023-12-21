package com.vn.ssl_be.domain.lesson.dto.request;

import com.vn.ssl_be.domain.lesson.model.Answer;
import com.vn.ssl_be.domain.lesson.model.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class QuestionRequest {
    private Long questionId;
    private String questionText;
    private Lesson lesson;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private Answer answer;
}
