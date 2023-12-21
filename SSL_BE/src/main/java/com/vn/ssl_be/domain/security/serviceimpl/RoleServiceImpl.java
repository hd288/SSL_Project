package com.vn.ssl_be.domain.security.serviceimpl;

import com.vn.ssl_be.common.exception.DomainException;
import com.vn.ssl_be.domain.security.model.Role;
import com.vn.ssl_be.domain.security.model.RoleName;
import com.vn.ssl_be.domain.security.repository.RoleRepository;
import com.vn.ssl_be.domain.security.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role findRoleByeRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName)
                .orElseThrow(() -> DomainException.notFound(roleName.name()));
    }
}
