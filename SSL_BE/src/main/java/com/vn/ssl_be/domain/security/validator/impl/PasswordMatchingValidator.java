package com.vn.ssl_be.domain.security.validator.impl;

import com.vn.ssl_be.domain.security.dto.request.SignupRequest;
import com.vn.ssl_be.domain.security.validator.PasswordMatching;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Getter
@Setter
public class PasswordMatchingValidator implements ConstraintValidator<PasswordMatching, Object> {
    private String password;
    private String confirmPassword;

    @Override
    public void initialize(PasswordMatching constraintAnnotation) {
        password = constraintAnnotation.password();
        this.confirmPassword = constraintAnnotation.confirmPassword();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // Cast the validated object to the appropriate type (SignupRequest in this case)
        SignupRequest signupRequest = (SignupRequest) value;

        // Retrieve the password and confirm password values
        String password = signupRequest.getPassword();
        String confirmPassword = signupRequest.getConfirmPassword();

        // Perform the validation logic
        boolean isValid = password != null && password.equals(confirmPassword);

        // Customize the error message if the validation fails
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation();
        }

        return isValid;
    }
}
