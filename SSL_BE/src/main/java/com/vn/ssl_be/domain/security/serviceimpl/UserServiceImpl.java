package com.vn.ssl_be.domain.security.serviceimpl;

import com.google.cloud.storage.Acl;
import com.vn.ssl_be.common.exception.DomainException;
import com.vn.ssl_be.domain.security.dto.request.ChangePasswordRequest;
import com.vn.ssl_be.domain.security.exception.UserException;
import com.vn.ssl_be.domain.security.model.User;
import com.vn.ssl_be.domain.security.repository.UserRepository;
import com.vn.ssl_be.domain.security.service.UserService;
import com.vn.ssl_be.domain.student.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public User findById(String userId) throws UserException {
        return userRepository.findById(userId).orElseThrow(() -> UserException.notFound("Could not found Id"));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> DomainException.notFound(email));
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void changePassword(ChangePasswordRequest changePasswordRequest) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = findByEmail(userDetails.getUsername());

        Boolean checkOldPasswor = passwordEncoder.matches(changePasswordRequest.getOldPassword(), user.getPassword());
        if(!checkOldPasswor) {
            throw UserException.badRequest("Enter Old Password not match!");
        }
        user.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));
        userRepository.save(user);
    }

    @Override
    public void toggleStatusById(String userId) {
        User user = findById(userId);
        user.setEnable(!user.isEnable());
        userRepository.save(user);
    }
}
