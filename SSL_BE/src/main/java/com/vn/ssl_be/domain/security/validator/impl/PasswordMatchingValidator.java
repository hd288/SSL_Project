package com.vn.ssl_be.domain.security.validator.impl;

import com.vn.ssl_be.domain.security.validator.PasswordMatching;
import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchingValidator implements ConstraintValidator<PasswordMatching, Object> {

    private String password;
    private String confirmPassword;

    @Override
    public void initialize(PasswordMatching matching) {
        this.password = matching.password();
        this.confirmPassword = matching.confirmPassword();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Object passwordValue = new BeanWrapperImpl(value).getPropertyValue(password);
        Object confirmPasswordValue = new BeanWrapperImpl(value).getPropertyValue(confirmPassword);
        //--------------------------------
        constraintValidatorContext.buildConstraintViolationWithTemplate(constraintValidatorContext.getDefaultConstraintMessageTemplate())
                .addPropertyNode(this.confirmPassword)
                .addConstraintViolation();

        return (passwordValue != null) ? passwordValue.equals(confirmPasswordValue) : confirmPasswordValue == null;
    }
}
