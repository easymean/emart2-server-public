package com.emart2.redirect.user.api;

import com.emart2.redirect.auth.entity.UserImpl;
import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.user.application.UserManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class ManageUserController {

  private UserManager userManager;

  public ManageUserController(UserManager userManager){
    this.userManager = userManager;
  }

  @GetMapping("/test")
  public void test(@AuthenticationPrincipal UserImpl user) {
    System.out.println(user.getUsername());

  }

  @PutMapping("/{id}")
  public CommonResponse<Void> approveUser(@PathVariable("id") Long id) {
    userManager.approveUser(id);
    return CommonResponse.ok();
  }
}
