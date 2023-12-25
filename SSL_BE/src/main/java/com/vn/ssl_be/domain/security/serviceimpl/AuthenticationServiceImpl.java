package com.vn.ssl_be.domain.security.serviceimpl;

import com.google.api.Http;
import com.vn.ssl_be.domain.security.dto.request.LoginRequest;
import com.vn.ssl_be.domain.security.dto.request.SignupRequest;
import com.vn.ssl_be.domain.security.dto.request.TokenRefreshRequest;
import com.vn.ssl_be.domain.security.dto.response.MessageResponse;
import com.vn.ssl_be.domain.security.dto.response.UserInfoResponse;
import com.vn.ssl_be.domain.security.exception.LoginFailException;
import com.vn.ssl_be.domain.security.jwt.JwtProvider;
import com.vn.ssl_be.domain.security.model.RefreshToken;
import com.vn.ssl_be.domain.security.model.Role;
import com.vn.ssl_be.domain.security.model.RoleName;
import com.vn.ssl_be.domain.security.model.User;
import com.vn.ssl_be.domain.security.repository.UserRepository;
import com.vn.ssl_be.domain.security.service.AuthenticationService;
import com.vn.ssl_be.domain.security.service.RefreshTokenService;
import com.vn.ssl_be.domain.security.service.RoleService;
import com.vn.ssl_be.domain.student.model.Student;
import com.vn.ssl_be.domain.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserServiceImpl userService;
    private final RefreshTokenService refreshTokenService;
    private final StudentService studentService;
    private final RoleService roleService;


    @Override
    public UserInfoResponse handleAuthenticateUser(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        }catch (AuthenticationException e) {
            throw new LoginFailException("Email or password incorrect !");
        }

        User user = userService.findByEmail(loginRequest.getEmail());

        RefreshToken refreshToken =  refreshTokenService.createRefreshToken(user);

        String accessToken = jwtProvider.generateTokenFromEmail(loginRequest.getEmail());

        List<String> roles =  user.getRoles()
                .stream()
                .map(role -> role.getRoleName().name())
                .toList();

        return UserInfoResponse.builder()
                .id(user.getUserId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .accessToken(accessToken)
                .refreshToken(refreshToken.getToken())
                .expiryDate(refreshToken.getExpiryDate())
                .roles(roles)
                .image(user.getImage())
                .tokenType("Bearer")
                .build();
    }

    @Override
    public MessageResponse handleRegisterUser(SignupRequest signupRequest) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findRoleByeRoleName(RoleName.ROLE_STUDENT));

        User user =  new User();
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        user.setEmail(signupRequest.getEmail());
//        user.setPhoneNumber(signupRequest.getPhoneNumber());
//        user.setGender(signupRequest.isGender());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setCreateDate(new Date());
        user.setEnable(true);
        user.setRoles(roles);

        Student student = studentService.createStudent(user);
        studentService.save(student);

        return MessageResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("User registered successfully!")
                .build();
    }



    @Override
    public MessageResponse handleLogoutUser() {
        return null;
    }
}
