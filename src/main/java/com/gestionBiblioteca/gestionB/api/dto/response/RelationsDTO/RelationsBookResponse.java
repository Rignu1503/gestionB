package com.gestionBiblioteca.gestionB.api.dto.response.RelationsDTO;

import com.gestionBiblioteca.gestionB.api.dto.response.BookResponse;
import com.gestionBiblioteca.gestionB.api.dto.response.LoanResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationsBookResponse {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private int publication_year;

    /*----Relaciones----*/

    private LoanResponse loan;
    private BookResponse book;

}
