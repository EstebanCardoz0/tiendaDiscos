package com.estebancardozo.tiendadiscos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estebancardozo.tiendadiscos.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
