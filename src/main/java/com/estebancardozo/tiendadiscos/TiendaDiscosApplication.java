package com.estebancardozo.tiendadiscos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Tienda de Discos API", version = "v1", description = "API REST para la venta de vinilos, CDs y casettes"))
@SpringBootApplication
public class TiendaDiscosApplication {

  public static void main(String[] args) {
    SpringApplication.run(TiendaDiscosApplication.class, args);
  }

}
