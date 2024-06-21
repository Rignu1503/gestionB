package com.gestionBiblioteca.gestionB.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRQ {
  @Size(min = 0, max = 100, message = "Title exceeds the number of characters allowed")
  @NotBlank(message = "Title is required.")
  private String title;
  @Size(min = 0, max = 100, message = "Author exceeds the number of characters allowed")
  @NotBlank(message = "Author is required.")
  private String author;
  @Size(min = 0, max = 20, message = "isbn exceeds the number of characters allowed")
  @NotBlank(message = "isbn is required.")
  private String isbn;
  @Size(min = 0, max = 50, message = "genre exceeds the number of characters allowed")
  @NotBlank(message = "genre is required.")
  private String genre;
  @NotNull(message = "Publication year is required")
  private int publication_year;
}
