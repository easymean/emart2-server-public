package com.emart2.redirect.user.api;

import com.emart2.redirect.auth.api.resolver.LoginRequired;
import com.emart2.redirect.auth.entity.UserImpl;
import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.user.application.MyInfoManager;
import com.emart2.redirect.user.dto.MyInfoDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/my")
public class MyInfoController {

  private final MyInfoManager myInfoManager;

  public MyInfoController(MyInfoManager myInfoManager) {
    this.myInfoManager = myInfoManager;
  }

  @GetMapping
  public CommonResponse<MyInfoDto.Response> getMyInfo(@LoginRequired UserImpl user){
    return CommonResponse.ok("success", myInfoManager.getMyInfo(user));
  }
}
