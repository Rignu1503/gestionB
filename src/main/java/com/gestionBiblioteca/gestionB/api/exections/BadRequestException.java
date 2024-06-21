package com.gestionBiblioteca.gestionB.api.exections;

public class BadRequestException extends RuntimeException{
  public BadRequestException(String message) {
    super(message);
  }
}
