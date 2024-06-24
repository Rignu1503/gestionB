package com.gestionBiblioteca.gestionB.infrastructure.service;

import com.gestionBiblioteca.gestionB.utils.mappers.LoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gestionBiblioteca.gestionB.api.dto.request.LoanRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.LoanResponse;
import com.gestionBiblioteca.gestionB.api.exections.BadRequestException;
import com.gestionBiblioteca.gestionB.domain.entities.LoanEntity;
import com.gestionBiblioteca.gestionB.domain.repositories.LoanRepository;
import com.gestionBiblioteca.gestionB.infrastructure.abtract_service.ILoanService;
import com.gestionBiblioteca.gestionB.utils.enums.SortType;

import com.gestionBiblioteca.gestionB.utils.messages.ErrorMessages;

import java.time.LocalDateTime;

@Service
public class LoanService implements ILoanService {

    @Autowired
    private LoanMapper loanMapper;

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public LoanResponse create(LoanRQ request) {
        LoanEntity loan = loanMapper.loanToLoanEntity(request);

        LocalDateTime date = LocalDateTime.now();
        loan.setLoan_date(date);

        LoanEntity loanSaved = loanRepository.save(loan);

        return loanMapper.toLeanResponse(loanSaved);
    }

    @Override
    public LoanResponse get(Long id) {

        return this.loanMapper.toLeanResponse(this.find(id));
    }

    @Override
    public LoanResponse update(LoanRQ request, Long id) {

        LoanEntity loan = this.find(id);

        loanMapper.updateLoan(request, loan);
        loan.setLoan_date(LocalDateTime.now());

        LoanEntity loanSaved = loanRepository.save(loan);

        return loanMapper.toLeanResponse(loanSaved);
    }

    @Override
    public void delete(Long id) {

        LoanEntity loan = this.find(id);
        loanRepository.delete(loan);

    }

    @Override
    public Page<LoanResponse> getAll(int page, int size, SortType sortType) {
        
        
        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by("id").ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by("id").descending());
        }

        return this.loanRepository.findAll(pagination).map(loanMapper::toLeanResponse);
    }

    private LoanEntity find(Long id) {

        return this.loanRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("loan")));
    }

}
