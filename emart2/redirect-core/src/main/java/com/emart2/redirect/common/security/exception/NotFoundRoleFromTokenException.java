package com.emart2.redirect.common.security.exception;

import com.emart2.redirect.common.exception.CommonException;
import com.emart2.redirect.type.ErrorType;

public class NotFoundRoleFromTokenException extends CommonException {
  public NotFoundRoleFromTokenException() {
    super("토큰에 권한이 없습니다. ", ErrorType.INVALID_TOKEN);
  }
}
