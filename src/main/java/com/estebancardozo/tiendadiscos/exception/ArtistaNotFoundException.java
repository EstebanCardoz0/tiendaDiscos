package com.estebancardozo.tiendadiscos.exception;

public class ArtistaNotFoundException extends RuntimeException {

  public ArtistaNotFoundException(Long id) {
    super("Artista " + id + " no encontrado");
  }

}
