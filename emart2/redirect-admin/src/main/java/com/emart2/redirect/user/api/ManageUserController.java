package com.emart2.redirect.user.api;

import com.emart2.redirect.auth.entity.UserAccount;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class ManageUserController {

  @GetMapping("/test")
  public void test(@AuthenticationPrincipal UserAccount user) {
    System.out.println(user.getUsername());

  }
}
