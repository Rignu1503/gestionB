package com.gestionBiblioteca.gestionB.infrastructure.abtract_service;

import com.gestionBiblioteca.gestionB.api.dto.request.ReservationRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.RelationsDTO.RelationsReservationResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IReservationService extends CRUD<ReservationRQ, RelationsReservationResponse, Long> {

}
