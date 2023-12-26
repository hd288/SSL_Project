package com.vn.ssl_be.domain.security.repository;


import com.vn.ssl_be.domain.security.model.Role;
import com.vn.ssl_be.domain.security.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}

