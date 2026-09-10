package com.estebancardozo.tiendadiscos.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.HashMap;
import org.springframework.validation.FieldError;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ArtistaNotFoundException.class)
  public ProblemDetail handleArtistaNotFound(ArtistaNotFoundException ex) {
    return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ProblemDetail handleValidationErrors(MethodArgumentNotValidException ex) {

    Map<String, String> errores = new HashMap<>();
    for (FieldError ferr : ex.getFieldErrors()) {
      errores.put(ferr.getField(), ferr.getDefaultMessage());
    }

    ProblemDetail prom = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Datos invalidos");
    prom.setProperty("errores", errores);

    return prom;

  }

}
