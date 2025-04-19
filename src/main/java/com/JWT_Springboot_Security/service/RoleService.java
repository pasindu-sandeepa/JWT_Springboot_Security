package com.JWT_Springboot_Security.service;

import com.JWT_Springboot_Security.entity.Role;
import com.JWT_Springboot_Security.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public Role createNewRole(Role role){
        return roleRepo.save(role);
    }
}
