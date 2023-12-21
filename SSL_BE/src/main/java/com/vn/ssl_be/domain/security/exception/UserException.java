package com.vn.ssl_be.domain.security.exception;

import com.vn.ssl_be.common.exception.DomainException;

public class UserException extends DomainException {
    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }


}
