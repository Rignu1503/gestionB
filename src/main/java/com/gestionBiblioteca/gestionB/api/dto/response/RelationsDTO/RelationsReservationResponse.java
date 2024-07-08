package com.gestionBiblioteca.gestionB.api.dto.response.RelationsDTO;

import com.gestionBiblioteca.gestionB.api.dto.response.BookResponse;
import com.gestionBiblioteca.gestionB.api.dto.response.UserResponse;
import com.gestionBiblioteca.gestionB.utils.enums.StatusReservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationsReservationResponse {
    private Long id;
    private LocalDateTime reservation_date;
    private StatusReservation status;

    private UserResponse user;
    private BookResponse book;
}
