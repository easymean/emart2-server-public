package com.emart2.redirect.user.application;

import com.emart2.redirect.user.dto.MyInfoDto;
import com.emart2.redirect.user.entity.User;
import com.emart2.redirect.user.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class MyInfoManager {
    private UserService userService;
    private final MyInfoMapper myInfoMapper;


    public MyInfoManager(UserService userService, MyInfoMapper myInfoMapper){
        this.userService = userService;
        this.myInfoMapper = myInfoMapper;
    }

    public MyInfoDto.Response getMyInfo(User user){
        return myInfoMapper.toDto(userService.getMyInfo(user.getId()));
    }
}
