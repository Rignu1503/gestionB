package com.gestionBiblioteca.gestionB.api.controllers;


import com.gestionBiblioteca.gestionB.api.dto.request.ReservationRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.RelationsDTO.RelationsReservationResponse;
import com.gestionBiblioteca.gestionB.infrastructure.abtract_service.IReservationService;
import com.gestionBiblioteca.gestionB.utils.enums.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "reservation")
@AllArgsConstructor
public class ReservationController {

    @Autowired
    private IReservationService reservationService;



    @PostMapping
    public ResponseEntity<RelationsReservationResponse> create(
            @Validated @RequestBody ReservationRQ reservationRQ){

        return ResponseEntity.ok(reservationService.create(reservationRQ));
    }

    @GetMapping
    public ResponseEntity <Page<RelationsReservationResponse>> get(
            @Validated @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestHeader(required = false) SortType sortType){

        if (Objects.isNull(sortType))
            sortType = SortType.NONE;

        return ResponseEntity.ok(reservationService.getAll(page -1, size, sortType));

    }

    @GetMapping( path = "/{id}")
    public ResponseEntity<RelationsReservationResponse> getById(
           @Validated @PathVariable Long id) {

        return ResponseEntity.ok(this.reservationService.get(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<RelationsReservationResponse> update(
            @Validated @PathVariable Long id,
            @RequestBody ReservationRQ reservationRQ){

        return ResponseEntity.ok(reservationService.update(reservationRQ, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RelationsReservationResponse> delete(
            @Validated @PathVariable Long id){

        this.reservationService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
