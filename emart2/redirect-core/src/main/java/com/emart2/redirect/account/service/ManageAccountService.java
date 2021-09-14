package com.emart2.redirect.account.service;

import com.emart2.redirect.account.entity.AccountEntity;
import com.emart2.redirect.account.exception.AccountAccessDeniedException;
import com.emart2.redirect.account.exception.AccountNotFoundException;
import com.emart2.redirect.account.repository.AccountRepository;
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

  public AccountEntity findById(Long id) {
    return accountRepository.findByIdAndIsActiveIsTrue(id).orElseThrow(AccountNotFoundException::new);
  }

  public AccountEntity createAccount(Long userId, AccountEntity account) {
    userRepository.findById(userId)
        .map(user -> {
          user.addAccount(account);
          user = userRepository.save(user);
          account.setUser(user);
          return user;
        })
        .orElseThrow(AccountAccessDeniedException::new);
    return accountRepository.save(account);
  }

  public AccountEntity updateAccount(Long userId, AccountEntity account) {
    if (!account.getUser().getId().equals(userId)) {
      throw new AccountAccessDeniedException();
    }
    return accountRepository.save(account);
  }

  public void deleteAccount(Long userId, Long id) {
    AccountEntity account = accountRepository.findByIdAndIsActiveIsTrue(id)
        .orElseThrow(AccountNotFoundException::new);

    if (!account.getUser().getId().equals(userId)) {
      throw new AccountAccessDeniedException();
    }
    account.setActive(false);
    accountRepository.save(account);
  }
}
