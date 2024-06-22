package com.gestionBiblioteca.gestionB.utils.mappers;

import com.gestionBiblioteca.gestionB.api.dto.request.BookRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.BookResponse;
import com.gestionBiblioteca.gestionB.domain.entities.BookEntity;
import com.gestionBiblioteca.gestionB.domain.entities.UserEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    BookEntity bookToBookEntity(BookRQ book);

    BookResponse toUserResponse (UserEntity userEntity);



}
