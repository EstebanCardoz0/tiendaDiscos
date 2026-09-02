package com.estebancardozo.tiendadiscos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estebancardozo.tiendadiscos.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
