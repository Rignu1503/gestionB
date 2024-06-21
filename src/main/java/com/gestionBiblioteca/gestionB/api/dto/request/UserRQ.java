package com.gestionBiblioteca.gestionB.api.dto.request;

import com.gestionBiblioteca.gestionB.utils.enums.Role;

import jakarta.validation.constraints.Email;
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
public class UserRQ {
  @Size(min = 0, max = 100, message = "User Name exceeds the number of characters allowed")
  @NotBlank(message = "The user name is required.")
  private String username;
  @Size(min = 0, max = 100, message = "Email exceeds the number of characters allowed")
  @NotBlank(message = "Email is required")
  @Email
  private String email;
  @Size(min = 0, max = 100, message = "Password exceeds the number of characters allowed")
  @NotBlank(message = "Password is required")
  private String password;
  @NotNull(message = "Rol is required")
  private Role role;
  @Size(min = 0, max = 100, message = "Name exceeds the number of characters allowed")
  @NotBlank(message = "Name is required.")
  private String full_name;
}
