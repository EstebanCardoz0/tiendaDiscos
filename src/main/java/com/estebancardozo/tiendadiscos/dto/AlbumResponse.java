package com.estebancardozo.tiendadiscos.dto;

public record AlbumResponse(Long id, String titulo, ArtistaResponse artista, Integer anio, String discografica, String genero) {

}
