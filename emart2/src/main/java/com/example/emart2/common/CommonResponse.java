package com.example.emart2.common;

import lombok.Getter;

@Getter
public class CommonResponse<T> {
  private final String errorCode;
  private final String message;
  private final T data;

  public CommonResponse(String code, String message, T data){
    this.errorCode = code;
    this.message = message;
    this.data = data;
  }

  public static <T> CommonResponse<T> ok(String message, T data){
    return new CommonResponse<>(null, message, data);
  }

  public static <T> CommonResponse<T> ok(T data){
    return new CommonResponse<>(null, "", data);
  }

  public static <T> CommonResponse<T> fail(String errorCode, String message){
    return new CommonResponse<>(errorCode, message, null);
  }

  public static CommonResponse<Void> ok(){
    return new CommonResponse<>(null, null, null);
  }


}
