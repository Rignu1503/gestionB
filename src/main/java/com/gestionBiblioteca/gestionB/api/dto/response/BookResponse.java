package com.gestionBiblioteca.gestionB.api.dto.response;


import com.gestionBiblioteca.gestionB.domain.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private int publication_year;
    private List<UserEntity> user;

}
