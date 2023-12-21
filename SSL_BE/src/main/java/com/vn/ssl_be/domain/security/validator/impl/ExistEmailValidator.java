package com.vn.ssl_be.domain.security.validator.impl;

import com.vn.ssl_be.domain.security.repository.UserRepository;
import com.vn.ssl_be.domain.security.validator.ExistEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExistEmailValidator implements ConstraintValidator<ExistEmail, String> {
    private final UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return email != null && !userRepository.existsByEmail(email);
    }
}
