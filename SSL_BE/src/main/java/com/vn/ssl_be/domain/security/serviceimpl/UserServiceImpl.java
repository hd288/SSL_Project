package com.vn.ssl_be.domain.security.serviceimpl;

import com.vn.ssl_be.common.exception.DomainException;
import com.vn.ssl_be.domain.security.model.User;
import com.vn.ssl_be.domain.security.repository.UserRepository;
import com.vn.ssl_be.domain.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> DomainException.notFound(email));
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
