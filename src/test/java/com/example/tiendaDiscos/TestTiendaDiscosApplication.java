package com.example.tiendaDiscos;

import org.springframework.boot.SpringApplication;

public class TestTiendaDiscosApplication {

	public static void main(String[] args) {
		SpringApplication.from(TiendaDiscosApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
