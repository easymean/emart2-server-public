package com.emart2.redirect.user.application;

import com.emart2.redirect.user.dto.MyInfoDto;
import com.emart2.redirect.user.service.MyInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MyInfoFinder {

  private final MyInfoMapper mapper;
  private final MyInfoService myInfoService;

  public MyInfoDto.Response getMyInfo(Long userId){
    return mapper.toDto(myInfoService.getMyInfo(userId));
  }
}
