package com.gestionBiblioteca.gestionB.infrastructure.service;

import com.gestionBiblioteca.gestionB.api.dto.request.ReservationRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.RelationsDTO.RelationsReservationResponse;
import com.gestionBiblioteca.gestionB.api.dto.response.ReservationResponse;
import com.gestionBiblioteca.gestionB.api.exections.BadRequestException;
import com.gestionBiblioteca.gestionB.domain.entities.ReservationEntity;
import com.gestionBiblioteca.gestionB.domain.repositories.ReservationRepository;
import com.gestionBiblioteca.gestionB.infrastructure.abtract_service.IReservationService;
import com.gestionBiblioteca.gestionB.utils.enums.SortType;
import com.gestionBiblioteca.gestionB.utils.mappers.ReservationMapper;
import com.gestionBiblioteca.gestionB.utils.messages.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService implements IReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    public RelationsReservationResponse create(ReservationRQ request) {

        ReservationEntity reservationEntity = reservationMapper.toEntity(request);

        LocalDateTime dateTime = LocalDateTime.now();
        reservationEntity.setReservation_date(dateTime);

        ReservationEntity savedEntity = reservationRepository.save(reservationEntity);

        return reservationMapper.toResponse(savedEntity);
    }

    @Override
    public RelationsReservationResponse get(Long id) {
        return reservationMapper.toResponse(findById(id));
    }

    @Override
    public RelationsReservationResponse update(ReservationRQ request, Long id) {

        ReservationEntity reservation =this.findById(id);
        LocalDateTime dateTime = LocalDateTime.now();
        reservation.setReservation_date(dateTime);

        ReservationEntity savedEntity = reservationRepository.save(reservation);

        return reservationMapper.toResponse(savedEntity);
    }

    @Override
    public void delete(Long id) {

        ReservationEntity reservation = this.findById(id);
        this.reservationRepository.delete(reservation);

    }

    @Override
    public Page<RelationsReservationResponse> getAll(int page, int size, SortType sortType) {


        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by("id").ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by("id").descending());
        }

        return this.reservationRepository.findAll(pagination).map(reservationMapper::toResponse);

    }


    private List<RelationsReservationResponse> findReservationByUserID(Long user_id) {

        List<RelationsReservationResponse> rlist = new ArrayList<>();
        for (ReservationEntity reservation : reservationRepository.findAll()) {
            if (reservation.getUser().getId() == user_id) rlist.add(reservationMapper.toResponse(reservation));
        }
        return rlist;
    }

    private ReservationEntity findById(Long id) {

        return this.reservationRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("reservation")));
    }
}
