package com.emart2.redirect.user.api;

import com.emart2.redirect.auth.entity.UserAccount;
import com.emart2.redirect.category.application.CategoryManager;
import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.user.application.UserManager;
import com.emart2.redirect.user.dto.ManageUserDto;
import com.emart2.redirect.user.dto.ResponseUserDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class ManageUserController {

  private final UserManager userManager;

  public ManageUserController(UserManager userManager) {
    this.userManager = userManager;
  }

  @GetMapping
  public CommonResponse<ManageUserDto> getAllUsers() {

    return CommonResponse.ok("success",null);
  }
}
