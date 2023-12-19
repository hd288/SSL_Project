package com.vn.ssl_be.domain.lesson.dto.response;

import com.vn.ssl_be.domain.lesson.model.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
    private Long questionId;
    private String questionText;
    private Long lessonId;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
}
