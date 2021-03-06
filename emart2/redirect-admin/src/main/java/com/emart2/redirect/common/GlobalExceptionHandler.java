package com.emart2.redirect.common;

import com.emart2.redirect.common.exception.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(CommonException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public CommonResponse<Object> handleException(CommonException ex) {
    logger.error(ex.getMessage());
    return CommonResponse.fail(ex.getMessage());
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public CommonResponse<Object> handleException(IllegalArgumentException ex) {
    logger.error(ex.getMessage());
    return CommonResponse.fail(ex.getMessage());
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public CommonResponse<Object> handleException(RuntimeException ex) {
    logger.error(ex.getMessage());
    return CommonResponse.fail(ex.getMessage());
  }

  @ExceptionHandler(UsernameNotFoundException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public CommonResponse<Object> handleException(UsernameNotFoundException ex) {
    logger.error(ex.getMessage());
    return CommonResponse.fail(ex.getMessage());
  }
}
