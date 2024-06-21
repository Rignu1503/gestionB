package com.gestionBiblioteca.gestionB.api.dto.request;

import java.time.LocalDateTime;

import com.gestionBiblioteca.gestionB.utils.enums.StatusLoan;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanRQ {
  @NotNull(message = "Date is required")
  @FutureOrPresent(message = "Date cannot be in the past")
  private LocalDateTime return_date;
  @NotNull(message = "Status is required")
  private StatusLoan status;
  @NotNull(message = "User is required")
  private Long user_id;
  @NotNull(message = "Book is required")
  private Long book_id;
}
