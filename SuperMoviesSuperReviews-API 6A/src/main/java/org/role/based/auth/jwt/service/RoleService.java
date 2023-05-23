package org.role.based.auth.jwt.service;

import org.role.based.auth.jwt.dao.RoleDao;
import org.role.based.auth.jwt.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
