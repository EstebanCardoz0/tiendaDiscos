package com.estebancardozo.tiendadiscos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estebancardozo.tiendadiscos.entity.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

}
