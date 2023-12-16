package com.vn.ssl_be.domain.course.exception;

import com.vn.ssl_be.common.exception.DomainException;

public class CourseException extends DomainException {
    public CourseException(String message) {
        super(message);
    }

    public CourseException(String message, Throwable cause) {
        super(message, cause);
    }
}
