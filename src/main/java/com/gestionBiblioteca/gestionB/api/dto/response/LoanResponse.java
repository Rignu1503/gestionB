package com.gestionBiblioteca.gestionB.api.dto.response;

import java.time.LocalDateTime;

import com.gestionBiblioteca.gestionB.utils.enums.StatusLoan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponse {
    
    private Long id;
     private LocalDateTime loan_date;
     private LocalDateTime return_date;
       private StatusLoan status;
}
