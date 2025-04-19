package com.JWT_Springboot_Security.service;

import com.JWT_Springboot_Security.entity.Role;
import com.JWT_Springboot_Security.entity.User;
import com.JWT_Springboot_Security.repo.RoleRepo;
import com.JWT_Springboot_Security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User regiterNewUser(User user) {
        return userRepo.save(user);
    }


    public void initRoleAndUser() {
        Role adminRole = new Role();
        Role userRole = new Role();
        if (!roleRepo.existsById("Admin")) {
            adminRole.setRoleName("Admin");
            adminRole.setRoleDescription("Admin role");
            roleRepo.save(adminRole);
        }

        if (!roleRepo.existsById("User")) {
            userRole.setRoleName("User");
            userRole.setRoleDescription("User role");
            roleRepo.save(userRole);
        }
        if(!userRepo.existsById("admin1234")){
            User user = new User();
            user.setUserName("admin123");
            user.setUserPassword(getEncodedPassword("admin123"));
            user.setUserFirstname("pasindu");
            user.setUserLastName("sandeepa");

            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);

            user.setRole(adminRoles);
            userRepo.save(user);

        }
        if(!userRepo.existsById("user123")){
            User user = new User();
            user.setUserName("user123");
            user.setUserPassword(getEncodedPassword("user123"));
            user.setUserFirstname("pasindu");
            user.setUserLastName("sandeepa");

            Set<Role> userRoles = new HashSet<>();
            userRoles.add(userRole);

            user.setRole(userRoles);
            userRepo.save(user);

        }

    }
    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
