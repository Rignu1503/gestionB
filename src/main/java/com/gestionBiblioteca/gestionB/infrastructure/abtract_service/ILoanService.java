package com.gestionBiblioteca.gestionB.infrastructure.abtract_service;

import com.gestionBiblioteca.gestionB.api.dto.request.LoanRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.LoanResponse;

public interface ILoanService extends CRUD<LoanRQ, LoanResponse, Long>{

    public final String FIELD_BY_SORT = "loan_date";
    
}
