package com.estebancardozo.tiendadiscos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estebancardozo.tiendadiscos.entity.Artista;
import com.estebancardozo.tiendadiscos.exception.ArtistaNotFoundException;
import com.estebancardozo.tiendadiscos.repository.ArtistaRepository;

@Service
public class ArtistaService {

  private final ArtistaRepository artistaRepo;

  public ArtistaService(ArtistaRepository artistaRepository) {
    this.artistaRepo = artistaRepository;
  }

  public List<Artista> findAll() {

    return artistaRepo.findAll();
  }

  public Artista findById(Long id) {
    return artistaRepo.findById(id).orElseThrow(() -> new ArtistaNotFoundException(id));

  }

  public Artista save(Artista artista) {
    return artistaRepo.save(artista);
  }

  public Artista update(Long id, Artista artista) {
    if (!artistaRepo.existsById(id)) {
      throw new ArtistaNotFoundException(id);
    }
    artista.setId(id);
    return artistaRepo.save(artista);
  }

  public void delete(Long id) {
    if (!artistaRepo.existsById(id)) {
      throw new ArtistaNotFoundException(id);
    }
    artistaRepo.deleteById(id);
    
  }

}