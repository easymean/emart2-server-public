package com.emart2.redirect.account.service;

import com.emart2.redirect.account.entity.AccountEntity;
import com.emart2.redirect.account.repository.AccountRepository;
import com.emart2.redirect.exception.AccessDeniedException;
import com.emart2.redirect.exception.NotFoundException;
import com.emart2.redirect.type.ErrorType;
import com.emart2.redirect.user.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class ManageAccountService {
  private final AccountRepository accountRepository;
  private final UserRepository userRepository;

  public ManageAccountService(AccountRepository accountRepository, UserRepository userRepository) {
    this.accountRepository = accountRepository;
    this.userRepository = userRepository;
  }

  public AccountEntity findById(Long id){
    return accountRepository.findByIdAndIsActiveIsTrue(id).orElseThrow(() -> new NotFoundException("id에 해당하는 계정이 존재하지 않습니다.", ErrorType.NOT_FOUND));
  }

  public AccountEntity createAccount(Long userId, AccountEntity account){
    userRepository.findById(userId)
        .map(user -> {
          user.addAccount(account);
          user = userRepository.save(user);
          account.setUser(user);
          return user;
        })
        .orElseThrow(()-> new AccessDeniedException("인증되지 않은 사용자입니다.", ErrorType.ACCESS_DENIED));
    return accountRepository.save(account);
  }

  public AccountEntity updateAccount(Long userId, AccountEntity account){
    if(!account.getUser().getId().equals(userId)){
      throw new AccessDeniedException("권한이 없습니다.", ErrorType.ACCESS_DENIED);
    }
    return accountRepository.save(account);
  }

  public void deleteAccount(Long userId, Long id) {
    AccountEntity account = accountRepository.findByIdAndIsActiveIsTrue(id)
        .orElseThrow(() -> new NotFoundException("id에 해당하는 계정이 존재하지 않습니다.", ErrorType.NOT_FOUND));

    if (!account.getUser().getId().equals(userId)) {
      throw new AccessDeniedException("권한이 없습니다.", ErrorType.ACCESS_DENIED);
    }
    account.setActive(false);
    accountRepository.save(account);
  }
}
