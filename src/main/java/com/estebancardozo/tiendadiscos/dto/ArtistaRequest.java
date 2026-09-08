package com.estebancardozo.tiendadiscos.dto;

import jakarta.validation.constraints.NotBlank;

public record ArtistaRequest(@NotBlank(message = "El nombre es obligatorio") String nombre, String pais) {

}