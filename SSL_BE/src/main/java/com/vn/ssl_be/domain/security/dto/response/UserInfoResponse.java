package com.vn.ssl_be.domain.security.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoResponse {
    private String id;
    private String email;
    private String fullName;
    private String accessToken;
    private String refreshToken;
    private List<String> roles;
    private String tokenType;
}
