package com.emart2.redirect.user.api;

import com.emart2.redirect.auth.api.resolver.AdminRequired;
import com.emart2.redirect.auth.entity.AdminUserImpl;
import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.user.application.MyInfoManager;
import com.emart2.redirect.user.dto.MyInfoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/my")
public class MyInfoController {

  private final MyInfoManager myInfoManager;

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  public MyInfoController(MyInfoManager myInfoManager) {
    this.myInfoManager = myInfoManager;
  }

  @GetMapping
  public CommonResponse<MyInfoDto.Response> getMyInfo(@AdminRequired AdminUserImpl user){
    return CommonResponse.ok("success", myInfoManager.getMyInfo(user));
  }
}
