package com.vn.ssl_be.controller;

import com.vn.ssl_be.common.exception.DomainException;
import com.vn.ssl_be.domain.security.dto.request.LoginRequest;
import com.vn.ssl_be.domain.security.dto.request.SignupRequest;
import com.vn.ssl_be.domain.security.dto.request.TokenRefreshRequest;
import com.vn.ssl_be.domain.security.dto.response.MessageResponse;
import com.vn.ssl_be.domain.security.dto.response.TokenRefreshResponse;
import com.vn.ssl_be.domain.security.dto.response.UserInfoResponse;
import com.vn.ssl_be.domain.security.exception.TokenRefreshException;
import com.vn.ssl_be.domain.security.jwt.JwtProvider;
import com.vn.ssl_be.domain.security.model.RefreshToken;
import com.vn.ssl_be.domain.security.service.AuthenticationService;
import com.vn.ssl_be.domain.security.service.RefreshTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationService authenticationService;
    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/sign-in")
    public ResponseEntity<UserInfoResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        return ResponseEntity.ok()
                .body(authenticationService.handleAuthenticateUser(loginRequest));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok()
                .body(authenticationService.handleRegisterUser(signupRequest));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@Valid @RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtProvider.generateTokenFromEmail(user.getEmail());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, UUID.randomUUID().toString()));
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }

    @DeleteMapping("/logout")
    public ResponseEntity<?> logout(@Valid @RequestBody TokenRefreshRequest logoutRequest) {
        RefreshToken refreshToken = refreshTokenService.findByToken(logoutRequest.getRefreshToken())
                .orElseThrow(() -> DomainException.notFound("RefreshToken " + logoutRequest.getRefreshToken()));

//        refreshTokenService.deleteToken(refreshToken);

        return ResponseEntity.ok("Logout success fully!");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutV1(@Valid @RequestBody TokenRefreshRequest logoutRequest) {
       refreshTokenService.findByToken(logoutRequest.getRefreshToken())
                .orElseThrow(() -> DomainException.notFound("RefreshToken " + logoutRequest.getRefreshToken()));

       refreshTokenService.deleteToken(logoutRequest);

        return ResponseEntity.ok("Logout success fully!");
    }
}
