package com.vn.ssl_be.domain.security.serviceimpl;

import com.vn.ssl_be.common.exception.DomainException;
import com.vn.ssl_be.domain.security.model.User;
import com.vn.ssl_be.domain.security.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> DomainException.notFound("User with email: " + email +" !"));

        return UserDetailsImpl.build(user);
    }

}

