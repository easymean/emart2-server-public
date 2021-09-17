package com.emart2.redirect.common.security.exception;

import com.emart2.redirect.common.exception.CommonException;
import com.emart2.redirect.type.ErrorType;

public class NotFoundUsernameFromTokenException extends CommonException {
  public NotFoundUsernameFromTokenException() {
    super("토큰에서 유저 이름을 찾을 수 없습니다. ", ErrorType.INVALID_TOKEN);
  }
}
