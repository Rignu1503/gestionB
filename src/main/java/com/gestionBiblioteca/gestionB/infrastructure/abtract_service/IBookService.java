package com.gestionBiblioteca.gestionB.infrastructure.abtract_service;

import com.gestionBiblioteca.gestionB.api.dto.request.BookRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.BookResponse;

public interface IBookService extends CRUD<BookRQ, BookResponse, Long>{

    public final String FIELD_BY_SORT = "title";
}
