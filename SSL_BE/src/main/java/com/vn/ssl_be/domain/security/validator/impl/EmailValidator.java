package com.vn.ssl_be.domain.security.validator.impl;

import com.vn.ssl_be.domain.security.validator.ValidEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+](.[_A-Za-z0-9-]+)*" +
            "@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        return email.matches(EMAIL_PATTERN);
    }
}
