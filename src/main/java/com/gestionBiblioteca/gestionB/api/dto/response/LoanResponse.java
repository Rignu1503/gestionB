package com.gestionBiblioteca.gestionB.api.dto.response;

import java.time.LocalDateTime;

import com.gestionBiblioteca.gestionB.utils.enums.StatusLoan;

public class LoanResponse {
    
    private Long id;
     private LocalDateTime loan_date;
     private LocalDateTime return_date;
       private StatusLoan status;
}
