package com.gestionBiblioteca.gestionB.api.dto.request;

import com.gestionBiblioteca.gestionB.utils.enums.StatusReservation;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRQ {
  @NotNull(message = "Status is required")
  private StatusReservation status;
  @NotNull(message = "User is required")
  private Long user_id;
  @NotNull(message = "Book is required")
  private Long book_id;
}

