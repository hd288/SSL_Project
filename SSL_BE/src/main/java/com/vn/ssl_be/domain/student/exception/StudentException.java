package com.vn.ssl_be.domain.student.exception;

import com.vn.ssl_be.common.exception.DomainException;

public class StudentException extends DomainException {
    public StudentException(String message) {
        super(message);
    }

    public StudentException(String message, Throwable cause) {
        super(message, cause);
    }


}
