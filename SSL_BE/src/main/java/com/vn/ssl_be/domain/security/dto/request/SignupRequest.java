package com.vn.ssl_be.domain.security.dto.request;

import com.vn.ssl_be.domain.security.validator.ExistEmail;
import com.vn.ssl_be.domain.security.validator.PasswordMatching;
import com.vn.ssl_be.domain.security.validator.StrongPassword;
import com.vn.ssl_be.domain.security.validator.ValidEmail;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

//    @Pattern(regexp = "^[0][1-9]{9,10}$" , message = "Invalid Phone Number")
//    @NotBlank(message = "Please enter Phone number")
//    private String phoneNumber;

//    @NotNull(message = "Please choose Gender")
//    private boolean gender;


}
