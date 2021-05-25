package com.example.emart2.common;

import com.example.emart2.type.EnumMapperType;
import lombok.Getter;

@Getter
public class EnumMapperValue {
  private String code;
  private String title;

  public EnumMapperValue(EnumMapperType enumMapperType){
    code = enumMapperType.getCode();
    title = enumMapperType.getTitle();
  }

  @Override
  public String toString(){
    return "{" +
        "code = '" +code + '\'' +
        ", title = '" + title + '\'' +
        '}';
  }
}
