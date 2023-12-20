package com.vn.ssl_be.domain.security.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {
    private HttpStatus httpStatus;
    private String message;

}
