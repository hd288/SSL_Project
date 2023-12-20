package com.vn.ssl_be.domain.lesson.exception;

import com.vn.ssl_be.common.exception.DomainException;

public class LessonException extends DomainException {
    public LessonException(String message) {
        super(message);
    }

    public LessonException(String message, Throwable cause) {
        super(message, cause);
    }


}
