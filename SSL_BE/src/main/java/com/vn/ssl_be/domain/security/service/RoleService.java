package com.vn.ssl_be.domain.security.service;

import com.vn.ssl_be.domain.security.model.Role;
import com.vn.ssl_be.domain.security.model.RoleName;

public interface RoleService {
    Role findRoleByeRoleName(RoleName roleName);
}
