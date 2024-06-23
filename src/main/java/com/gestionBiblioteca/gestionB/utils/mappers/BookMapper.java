package com.gestionBiblioteca.gestionB.utils.mappers;

import com.gestionBiblioteca.gestionB.api.dto.request.BookRQ;
import com.gestionBiblioteca.gestionB.api.dto.request.UserRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.BookResponse;
import com.gestionBiblioteca.gestionB.domain.entities.BookEntity;
import com.gestionBiblioteca.gestionB.domain.entities.UserEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    BookEntity bookToBookEntity(BookRQ book);

    BookResponse toBookResponse (BookEntity bookEntity);

    void updateBook(BookRQ bookRequest, @MappingTarget BookEntity bookEntity);



}
