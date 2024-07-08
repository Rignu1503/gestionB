package com.gestionBiblioteca.gestionB.infrastructure.abtract_service;

import com.gestionBiblioteca.gestionB.api.dto.request.BookRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.RelationsDTO.RelationsBookResponse;

public interface IBookService extends CRUD<BookRQ, RelationsBookResponse, Long> {

    public final String FIELD_BY_SORT = "title";
}
