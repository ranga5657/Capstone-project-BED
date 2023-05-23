package org.role.based.auth.jwt.controller;

import org.role.based.auth.jwt.entity.Role;
import org.role.based.auth.jwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4203")
public class RoleController {

    @Autowired
    private RoleService roleService;

    // admin can create new role 
    @PreAuthorize("hasRole('Admin')")
    @PostMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }
}
