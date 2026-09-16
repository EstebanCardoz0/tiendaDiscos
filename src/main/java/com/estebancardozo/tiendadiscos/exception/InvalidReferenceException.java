package com.estebancardozo.tiendadiscos.exception;

public class InvalidReferenceException extends RuntimeException {

    public InvalidReferenceException(String entity, Long id) {
        super("No se encontró " + entity + " con el id " + id);

    }
}
