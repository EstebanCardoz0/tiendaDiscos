package com.estebancardozo.tiendadiscos.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String entity, Long id) {
        super("No se encontró " + entity + " con el id " + id);

    }

}
