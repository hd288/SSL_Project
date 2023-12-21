package com.vn.ssl_be.domain.security.exception;

import javax.naming.AuthenticationException;

public class LoginFailException extends RuntimeException {
    public LoginFailException(String message) {
        super(message);
    }
}
