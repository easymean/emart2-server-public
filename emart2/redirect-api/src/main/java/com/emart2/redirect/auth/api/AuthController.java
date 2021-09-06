package com.emart2.redirect.auth.api;

import com.emart2.redirect.auth.application.LoginManager;
import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.auth.dto.LoginDto;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {
  private final LoginManager loginManager;

  public AuthController(LoginManager loginManager) {
    this.loginManager = loginManager;
  }

  @PostMapping("/login")
  public CommonResponse<LoginDto.Response> login(@RequestBody LoginDto.Login req, HttpServletResponse res) {
    String token = loginManager.login(req);
    Cookie cookie = new Cookie("accessToken", token);
    res.addCookie(cookie);
    return CommonResponse.ok("success", null);
  }

  @PostMapping("/signup")
  public CommonResponse<LoginDto.Response> signup(@RequestBody LoginDto.Signup req) {
    loginManager.signUp(req);
    return CommonResponse.ok("success", null);
  }
}
