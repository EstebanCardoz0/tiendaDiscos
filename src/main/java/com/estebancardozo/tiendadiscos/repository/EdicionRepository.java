package com.estebancardozo.tiendadiscos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estebancardozo.tiendadiscos.entity.Edicion;

public interface EdicionRepository extends JpaRepository<Edicion, Long> {

}
