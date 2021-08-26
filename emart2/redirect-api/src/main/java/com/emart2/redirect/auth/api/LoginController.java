package com.emart2.redirect.auth.api;

import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.auth.dto.LoginDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
public class LoginController {

  @PostMapping("/login")
  public CommonResponse<LoginDto.Response> login(@RequestBody LoginDto.Login req) {
    return null;
  }

  @GetMapping("/signup")
  public CommonResponse<LoginDto.Response> signup(@RequestBody LoginDto.Login req) {

    return null;
  }
}
