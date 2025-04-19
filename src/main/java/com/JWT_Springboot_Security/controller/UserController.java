package com.JWT_Springboot_Security.controller;

import com.JWT_Springboot_Security.entity.User;
import com.JWT_Springboot_Security.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping({"/register-new-user"})
    public User registerNewUser(@RequestBody User user){
        return userService.regiterNewUser(user);
    }

    @PostConstruct
     public void initRoleAndUser(){
        userService.initRoleAndUser();
    }

    @GetMapping({"for-admin"})
    public String forAdmin(){
        return "this url is only accessible for admin";
    }

    @GetMapping({"for-user"})
    public String forUser(){
        return "this url is only accessible for user";
    }

}
