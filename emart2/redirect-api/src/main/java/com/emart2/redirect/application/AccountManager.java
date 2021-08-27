package com.emart2.redirect.application;

import com.emart2.redirect.account.dto.ManageAccountDto;
import com.emart2.redirect.account.entity.AccountEntity;
import com.emart2.redirect.account.service.ManageAccountService;
import org.springframework.stereotype.Component;

@Component
public class AccountManager {
  private final ManageAccountService manageAccountService;
  private final ManageAccountMapper mapper;

  public AccountManager(ManageAccountService manageAccountService, ManageAccountMapper mapper) {
    this.manageAccountService = manageAccountService;
    this.mapper = mapper;
  }

  public ManageAccountDto.Response findAccount(Long id){
    return mapper.toDto(manageAccountService.findById(id));
  }

  public ManageAccountDto.Response createAccount(Long userId, ManageAccountDto.Request req){
    return mapper.toDto(manageAccountService.createAccount(userId, mapper.toEntity(req)));
  }

  public ManageAccountDto.Response updateAccount(Long userId, Long id, ManageAccountDto.Request req){
    manageAccountService.findById(id);
    AccountEntity account = manageAccountService.updateAccount(userId, mapper.toEntity(req));
    return mapper.toDto(account);
  }

  public void deleteAccount(Long userId, Long id){
    manageAccountService.deleteAccount(userId, id);
  }
}
