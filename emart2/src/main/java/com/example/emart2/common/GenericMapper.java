package com.example.emart2.common;

public interface GenericMapper<Req, Res ,E> {
  Res toDto(E entity);
  E toEntity(Req dto);
}
