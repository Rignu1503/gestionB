package com.gestionBiblioteca.gestionB.api.controllers;

import com.gestionBiblioteca.gestionB.api.dto.request.BookRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.BookResponse;
import com.gestionBiblioteca.gestionB.domain.repositories.BookRepository;
import com.gestionBiblioteca.gestionB.infrastructure.abtract_service.IBookService;
import com.gestionBiblioteca.gestionB.infrastructure.service.BookSerivice;
import com.gestionBiblioteca.gestionB.utils.enums.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.Objects;

@RestController
@RequestMapping(path = "book")
@AllArgsConstructor
public class BookController {

    @Autowired
    private IBookService bookSerivice;

    @PostMapping
    public ResponseEntity<BookResponse> create(
            @Validated @RequestBody BookRQ bookRQ){

        return ResponseEntity.ok(bookSerivice.create(bookRQ));
    }

    @GetMapping
    public ResponseEntity<Page<BookResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestHeader(required = false) SortType sortType
    ){
        if (Objects.isNull(sortType))
            sortType = SortType.NONE;


        return ResponseEntity.ok(bookSerivice.getAll(page -1, size, sortType));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BookResponse> getById(
            @PathVariable Long id){

        return ResponseEntity.ok(this.bookSerivice.get(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BookResponse> update(
            @PathVariable Long id,
            @Validated @RequestBody BookRQ bookRQ
    ){

        return ResponseEntity.ok(this.bookSerivice.update(bookRQ, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<BookResponse> delete(
            @PathVariable Long id
    ){

        this.bookSerivice.delete(id);

        return ResponseEntity.noContent().build();
    }


}
