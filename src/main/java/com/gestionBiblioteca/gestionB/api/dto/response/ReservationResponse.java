package com.gestionBiblioteca.gestionB.api.dto.response;

import com.gestionBiblioteca.gestionB.utils.enums.StatusLoan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {

    private Long id;
    private LocalDateTime loan_date;
    private LocalDateTime return_date;
    private StatusLoan status;

}
