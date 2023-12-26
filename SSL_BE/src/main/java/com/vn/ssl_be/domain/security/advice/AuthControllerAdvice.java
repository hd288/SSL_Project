package com.vn.ssl_be.domain.security.advice;


import com.vn.ssl_be.domain.security.dto.response.MessageResponse;
import com.vn.ssl_be.domain.security.exception.LoginFailException;
import com.vn.ssl_be.domain.security.exception.TokenRefreshException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AuthControllerAdvice {

    @ExceptionHandler(LoginFailException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public MessageResponse handleLoginFailException(LoginFailException e) {
        return new MessageResponse(HttpStatus.UNAUTHORIZED, e.getMessage(), new HashMap<>());
    }


    @ExceptionHandler(value = TokenRefreshException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public MessageResponse handleRefreshTokenException
            (TokenRefreshException e, WebRequest request) {
        return new MessageResponse(HttpStatus.FORBIDDEN, e.getMessage(), new HashMap<>());
    }

}
