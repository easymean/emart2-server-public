package com.emart2.redirect.account.exception;

import com.emart2.redirect.common.exception.CommonException;
import com.emart2.redirect.type.ErrorType;

public class AccountAccessDeniedException extends CommonException {
  public AccountAccessDeniedException() {
    super("접근 권한이 없는 계정정보입니다.", ErrorType.ACCESS_DENIED);
  }
}
