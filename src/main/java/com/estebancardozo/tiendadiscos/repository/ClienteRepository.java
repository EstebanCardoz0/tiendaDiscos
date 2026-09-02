package com.estebancardozo.tiendadiscos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estebancardozo.tiendadiscos.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
