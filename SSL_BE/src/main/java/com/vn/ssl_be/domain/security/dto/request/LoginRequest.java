package com.vn.ssl_be.domain.security.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Please enter Email !")
    private String email;
    @NotBlank(message = "Please enter Password !")
    private String password;
}
