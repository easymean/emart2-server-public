package com.emart2.redirect.account.api;

import com.emart2.redirect.account.dto.ManageAccountDto;
import com.emart2.redirect.account.application.AccountManager;
import com.emart2.redirect.common.CommonResponse;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/accounts")
public class ManageAccountController {

  private final AccountManager accountManager;

  public ManageAccountController(AccountManager accountManager) {
    this.accountManager = accountManager;
  }

  @GetMapping
  public CommonResponse<Void> getAccountList(){
    return null;
  }

  @GetMapping("{id}")
  public CommonResponse<ManageAccountDto.Response> getAccount(@PathVariable("id") Long id){
    return CommonResponse.ok("success", accountManager.findAccount(id));
  }

  @PostMapping
  public CommonResponse<ManageAccountDto.Response> createAccount(
      Long userId,
      @RequestBody ManageAccountDto.Request req){
    return CommonResponse.ok("success", accountManager.createAccount(userId, req));
  }

  @PutMapping("{id}")
  public CommonResponse<ManageAccountDto.Response> updateAccount(Long userId, @PathVariable("id") Long id
  , @RequestBody ManageAccountDto.Request req){
    return CommonResponse.ok("success", accountManager.updateAccount(userId, id, req));
  }

  @DeleteMapping("/{id}")
  public CommonResponse<Void> deleteAccount(Long userId, @PathVariable("id") Long id){
    accountManager.deleteAccount(userId, id);
    return CommonResponse.ok();
  }
}
