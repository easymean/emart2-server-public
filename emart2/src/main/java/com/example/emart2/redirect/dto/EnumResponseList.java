package com.example.emart2.redirect.dto;

import com.example.emart2.common.EnumMapperValue;
import lombok.Getter;

import java.util.List;

@Getter
public class EnumResponseList {

  private List<EnumMapperValue> enumValueList;
  public EnumResponseList(List<EnumMapperValue> enumValueList){
    this.enumValueList = enumValueList;
  }
}
