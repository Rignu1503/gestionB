package com.gestionBiblioteca.gestionB.utils.mappers;

import com.gestionBiblioteca.gestionB.api.dto.request.ReservationRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.RelationsDTO.RelationsReservationResponse;
import com.gestionBiblioteca.gestionB.domain.entities.ReservationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RevervationMapper {


    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "book.id", source = "book_id"),
            @Mapping(target = "user.id", source = "user_id")
    })
    ReservationEntity toEntity(ReservationRQ reservationRQ);

    RelationsReservationResponse toResponse(ReservationEntity reservationEntity);

    void updateEntity(ReservationRQ reservationRQ, @MappingTarget ReservationEntity reservationEntity);



}
