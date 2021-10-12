package com.emart2.redirect.user.api;

import com.emart2.redirect.auth.entity.UserAccount;
import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.user.application.MyInfoMapper;
import com.emart2.redirect.user.dto.MyInfoDto;
import com.emart2.redirect.user.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/my")
public class MyInfoController {

  private final MyInfoMapper myInfoMapper;
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  public MyInfoController(MyInfoMapper myInfoMapper) {
    this.myInfoMapper = myInfoMapper;
  }

  @GetMapping
  public CommonResponse<MyInfoDto.Response> getMyInfo(@AuthenticationPrincipal UserAccount userAccount){
    UserEntity user = userAccount!=null? userAccount.getUser(): new UserEntity();
    return CommonResponse.ok("success", myInfoMapper.toDto(user));
  }
}
