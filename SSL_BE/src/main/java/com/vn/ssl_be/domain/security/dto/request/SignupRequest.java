package com.vn.ssl_be.domain.security.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vn.ssl_be.domain.security.validator.ExistEmail;
import com.vn.ssl_be.domain.security.validator.PasswordMatching;
import com.vn.ssl_be.domain.security.validator.StrongPassword;
import com.vn.ssl_be.domain.security.validator.ValidEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@PasswordMatching(
        password = "password",
        confirmPassword = "confirmPassword",
        message = "Password and Confirm Password must be matched!"
)
public class SignupRequest {

    @NotBlank(message = "Please enter First Name")
    private String firstName;

    @NotBlank(message = "Please enter Last Name")
    private String lastName;

    @ExistEmail
    @ValidEmail
    @NotBlank(message = "Please enter Email")
    private String email;

    @StrongPassword
    @NotBlank(message = "Please enter Password")
    private String password;

    @NotBlank(message = "Please enter ConfirmPassword")
    private String confirmPassword;


}
