package com.gestionBiblioteca.gestionB.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionBiblioteca.gestionB.domain.entities.LoanEntity;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity,Long>{
  
}
