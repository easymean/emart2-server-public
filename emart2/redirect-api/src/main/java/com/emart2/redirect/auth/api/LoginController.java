package com.emart2.redirect.auth.api;

import com.emart2.redirect.auth.application.LoginManager;
import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.auth.dto.LoginDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
public class LoginController {
  private final LoginManager loginManager;

  public LoginController(LoginManager loginManager) {
    this.loginManager = loginManager;
  }

  @PostMapping("/login")
  public CommonResponse<LoginDto.Response> login(@RequestBody LoginDto.Login req) {
    return null;
  }

  @PostMapping("/signup")
  public CommonResponse<Void> signup(@RequestBody LoginDto.Login req) {
    loginManager.signUp(req);
    return CommonResponse.ok("success", null);
  }
}
