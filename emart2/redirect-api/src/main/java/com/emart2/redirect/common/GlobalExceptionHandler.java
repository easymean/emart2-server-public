package com.emart2.redirect.common;

import com.emart2.redirect.auth.exception.UsernameNotFoundException;
import com.emart2.redirect.auth.exception.WrongPasswordException;
import com.emart2.redirect.common.exception.CommonException;
import com.emart2.redirect.common.security.exception.NotFoundExpirationFromTokenException;
import com.emart2.redirect.common.security.exception.NotFoundRoleFromTokenException;
import com.emart2.redirect.common.security.exception.NotFoundUsernameFromTokenException;
import com.emart2.redirect.type.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


  /**
   * login exception
   **/
  @ExceptionHandler({UsernameNotFoundException.class, WrongPasswordException.class})
  @ResponseStatus(HttpStatus.ACCEPTED)
  public CommonResponse<Object> handleLoginException(CommonException ex){
    logger.error(ex.getMessage());
    return CommonResponse.fail(ex.getMessage(), ex.getErrorType());
  }

  /**
  *  token exception
  **/
  @ExceptionHandler({NotFoundExpirationFromTokenException.class,
          NotFoundRoleFromTokenException.class, NotFoundUsernameFromTokenException.class})
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public CommonResponse<Object> handleTokenException(CommonException ex) {
    logger.error(ex.getMessage());
    return CommonResponse.fail(ex.getMessage(), ErrorType.ACCESS_DENIED);
  }

  @ExceptionHandler(CommonException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public CommonResponse<Object> handleException(CommonException ex) {
    logger.error(ex.getMessage());
    return CommonResponse.fail(ex.getMessage(), ex.getErrorType());
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public CommonResponse<Object> handleException(IllegalArgumentException ex) {
    logger.error(ex.getMessage());
    return CommonResponse.fail(ex.getMessage(), ErrorType.ILLEGAL_ARGUMENT);
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public CommonResponse<Object> handleException(RuntimeException ex) {
    logger.error(ex.getMessage());
    return CommonResponse.fail(ex.getMessage(), ErrorType.RUNTIME_ERROR);
  }


}
