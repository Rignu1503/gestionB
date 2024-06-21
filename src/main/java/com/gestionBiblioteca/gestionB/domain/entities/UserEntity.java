package com.gestionBiblioteca.gestionB.domain.entities;

import java.util.List;

import com.gestionBiblioteca.gestionB.utils.enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, length = 100)
  private String username;
  @Column(nullable = false, length = 100)
  private String password;
  @Column(nullable = false, length = 100)
  private String email;
  @Column(nullable = false, length = 100)
  private String full_name;
  @Column(nullable = false, length = 20)
  @Enumerated(EnumType.STRING)
  private Role role;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "user",fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = false)
  private List<LoanEntity> loanList;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  private List<ReservationEntity> reservationList;
}
