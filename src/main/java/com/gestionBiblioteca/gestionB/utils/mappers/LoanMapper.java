package com.gestionBiblioteca.gestionB.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.gestionBiblioteca.gestionB.api.dto.request.LoanRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.LoanResponse;
import com.gestionBiblioteca.gestionB.domain.entities.LoanEntity;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {BookMapper.class, UserMapper.class})
public interface LoanMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "user.id", source = "user_id"),
            @Mapping(target = "book.id", source = "book_id"),
            @Mapping(target = "loan_date", ignore = true),
    })
    LoanEntity loanToLoanEntity(LoanRQ bookRQ);

    LoanResponse toLeanResponse(LoanEntity loanEntity);

    void updateLoan(LoanRQ LoanRequest, @MappingTarget LoanEntity loanEntity);

}