package com.emart2.redirect.user.application;

import com.emart2.redirect.user.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserManager {
    private UserService userService;

    public UserManager(UserService userService){
        this.userService = userService;
    }

    public void approveUser(Long id){
        userService.approveUser(id);
    }
}
