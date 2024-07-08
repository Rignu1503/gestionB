package com.gestionBiblioteca.gestionB.infrastructure.service;

import com.gestionBiblioteca.gestionB.api.dto.request.BookRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.RelationsDTO.RelationsBookResponse;
import com.gestionBiblioteca.gestionB.api.exections.BadRequestException;
import com.gestionBiblioteca.gestionB.domain.entities.BookEntity;
import com.gestionBiblioteca.gestionB.domain.repositories.BookRepository;
import com.gestionBiblioteca.gestionB.infrastructure.abtract_service.IBookService;
import com.gestionBiblioteca.gestionB.utils.enums.SortType;
import com.gestionBiblioteca.gestionB.utils.mappers.BookMapper;
import com.gestionBiblioteca.gestionB.utils.messages.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookSerivice implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public RelationsBookResponse create(BookRQ request) {

        BookEntity book = bookMapper.bookToBookEntity(request);
        BookEntity bookSaved = bookRepository.save(book);

        return bookMapper.toRelationsBookResponse(bookSaved);
    }

    @Override
    public RelationsBookResponse get(Long id) {
        return this.bookMapper.toRelationsBookResponse(this.find(id));
    }

    @Override
    public RelationsBookResponse update(BookRQ request, Long id) {

        BookEntity book = this.find(id);

        bookMapper.updateBook(request, book);
        BookEntity bookSaved = bookRepository.save(book);

        return bookMapper.toRelationsBookResponse(bookSaved);
    }

    @Override
    public void delete(Long id) {

        BookEntity book = this.find(id);
        bookRepository.delete(book);
    }

    @Override
    public Page<RelationsBookResponse> getAll(int page, int size, SortType sortType) {

        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.bookRepository.findAll(pagination).map(bookMapper::toRelationsBookResponse);

    }

    private BookEntity find(Long id) {

        return this.bookRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("book")));
    }

}
