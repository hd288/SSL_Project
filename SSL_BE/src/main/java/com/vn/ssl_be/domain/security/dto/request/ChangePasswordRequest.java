package com.vn.ssl_be.domain.security.dto.request;

import com.vn.ssl_be.domain.security.validator.PasswordMatching;
import com.vn.ssl_be.domain.security.validator.StrongPassword;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@PasswordMatching(
        password = "newPassword",
        confirmPassword = "confirmNewPassword",
        message = "New Password and Confirm New Password are not matching!"
)
public class ChangePasswordRequest {
    @NotBlank(message = "Please enter your Old Password")
    private String oldPassword;

    @StrongPassword
    @NotBlank(message = "Please enter Password")
    private String newPassword;

    @NotBlank(message = "Please enter ConfirmPassword")
    private String confirmNewPassword;
}
