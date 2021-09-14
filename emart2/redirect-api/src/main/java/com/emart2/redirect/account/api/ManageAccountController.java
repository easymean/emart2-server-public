package com.emart2.redirect.account.api;

import com.emart2.redirect.account.dto.ManageAccountDto;
import com.emart2.redirect.account.application.AccountManager;
import com.emart2.redirect.auth.entity.UserAccount;
import com.emart2.redirect.common.CommonResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/accounts")
public class ManageAccountController {

  private final AccountManager accountManager;

  public ManageAccountController(AccountManager accountManager) {
    this.accountManager = accountManager;
  }

  @GetMapping
  public CommonResponse<Void> getAccountList() {
    return null;
  }

  @GetMapping("{id}")
  public CommonResponse<ManageAccountDto.Response> getAccount(@PathVariable("id") Long id) {
    return CommonResponse.ok("success", accountManager.findAccount(id));
  }

  @PostMapping
  public CommonResponse<ManageAccountDto.Response> createAccount(
      @AuthenticationPrincipal UserAccount user,
      @RequestBody ManageAccountDto.Request req) {
    Long userId = user.getUser().getId();
    return CommonResponse.ok("success", accountManager.createAccount(userId, req));
  }

  @PutMapping("{id}")
  public CommonResponse<ManageAccountDto.Response> updateAccount(@AuthenticationPrincipal UserAccount user, @PathVariable("id") Long id
      , @RequestBody ManageAccountDto.Request req) {
    Long userId = user.getUser().getId();
    return CommonResponse.ok("success", accountManager.updateAccount(userId, id, req));
  }

  @DeleteMapping("/{id}")
  public CommonResponse<Void> deleteAccount(@AuthenticationPrincipal UserAccount user, @PathVariable("id") Long id) {
    Long userId = user.getUser().getId();
    accountManager.deleteAccount(userId, id);
    return CommonResponse.ok();
  }
}
