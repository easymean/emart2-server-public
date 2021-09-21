package com.emart2.redirect.auth.api;

import com.emart2.redirect.auth.application.LoginManager;
import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.auth.dto.LoginDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity login(@RequestBody LoginDto.Login req, HttpServletResponse res) {
    String token = loginManager.generateToken(req);
    ResponseCookie cookie = ResponseCookie.from("accessToken", token)
        .domain("localhost")
        .sameSite("None")
        .secure(true)
        .path("/")
        .build();
//    Cookie cookie = new Cookie("accessToken", token);
//    res.addCookie(cookie);
    res.addHeader("Set-Cookie", cookie.toString());
    //return new ResponseEntity<>(HttpStatus.OK);

    return ResponseEntity.ok()
            .body(loginManager.login(req));
  }

  @PostMapping("/signup")
  public CommonResponse<LoginDto.Response> signup(@RequestBody LoginDto.Signup req) {
    return CommonResponse.ok("success", loginManager.signUp(req));
  }

  @PostMapping("/unique")
  public CommonResponse<Boolean> checkId(@RequestBody String id) {
    return CommonResponse.ok("success", loginManager.checkId(id));
  }
}
