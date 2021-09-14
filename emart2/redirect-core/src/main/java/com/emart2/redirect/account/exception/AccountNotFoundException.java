package com.emart2.redirect.account.exception;

import com.emart2.redirect.common.exception.CommonException;
import com.emart2.redirect.type.ErrorType;

public class AccountNotFoundException extends CommonException {

  public AccountNotFoundException() {
    super("id에 해당하는 계정이 존재하지 않습니다.", ErrorType.NOT_FOUND);
  }
}
