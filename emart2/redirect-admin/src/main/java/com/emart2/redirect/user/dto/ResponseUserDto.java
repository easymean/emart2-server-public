package com.emart2.redirect.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseUserDto {

    private final Long id;
    private final String userId;

   @Builder
    public ResponseUserDto(Long id, String userId){
       this.id  =id;
       this.userId = userId;
   }

}
