package com.emart2.redirect.common.security.exception;

import com.emart2.redirect.common.exception.CommonException;
import com.emart2.redirect.type.ErrorType;

public class NotFoundExpirationFromTokenException extends CommonException {
  public NotFoundExpirationFromTokenException() {
    super("토큰만료일자를 찾을 수 없습니다. ", ErrorType.INVALID_TOKEN);
  }
}
