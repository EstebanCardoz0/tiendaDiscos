package com.estebancardozo.tiendadiscos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlbumRequest(@NotBlank(message = "El titulo es obligatorio") String titulo,
        @NotNull(message = "El año es obligatorio") Integer anio,
        String discografica, String genero, @NotNull(message = "El artista es obligatorio") Long artistaId) {
}