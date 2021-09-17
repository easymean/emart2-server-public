package com.emart2.redirect.user.api;

import com.emart2.redirect.auth.entity.UserAccount;
import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.user.application.MyInfoFinder;
import com.emart2.redirect.user.dto.MyInfoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/my")
public class MyInfoController {

  private final MyInfoFinder myInfoFinder;
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  public MyInfoController(MyInfoFinder myInfoFinder) {
    this.myInfoFinder = myInfoFinder;
  }

  @GetMapping
  public CommonResponse<MyInfoDto.Response> getMyInfo(@AuthenticationPrincipal UserAccount user){
    Long userId = user.getUser().getId();
    logger.info("==================");
    logger.info(String.valueOf(userId));
    return CommonResponse.ok("success", myInfoFinder.getMyInfo(userId));
  }
}
