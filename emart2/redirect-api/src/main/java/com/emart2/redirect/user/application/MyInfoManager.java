package com.emart2.redirect.user.application;

import com.emart2.redirect.user.dto.MyInfoDto;
import com.emart2.redirect.user.entity.User;
import com.emart2.redirect.user.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class MyInfoManager {
    private final UserService userService;
    private final MyInfoMapper mapper;

    public MyInfoManager(UserService userService, MyInfoMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    public MyInfoDto.Response getMyInfo(User user){
        return mapper.toDto(userService.getMyInfo(user.getId()));
    }
}
