package com.estebancardozo.tiendadiscos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estebancardozo.tiendadiscos.dto.ArtistaRequest;
import com.estebancardozo.tiendadiscos.dto.ArtistaResponse;
import com.estebancardozo.tiendadiscos.entity.Artista;
import com.estebancardozo.tiendadiscos.service.ArtistaService;
import com.estebancardozo.tiendadiscos.dto.ArtistaResponse;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {

  private final ArtistaService artistaSer;

  public ArtistaController(ArtistaService artistaSer) {
    this.artistaSer = artistaSer;
  }

  @GetMapping
  public List<ArtistaResponse> getAll() {
    return artistaSer.findAll().stream()
        .map(artista -> new ArtistaResponse(artista.getId(), artista.getNombre(), artista.getPais())).toList();

  }

  @PostMapping
  public ResponseEntity<ArtistaResponse> create(@Valid @RequestBody ArtistaRequest request) {

    Artista artista = new Artista();
    artista.setNombre(request.nombre());
    artista.setPais(request.pais());

    Artista artistaCreado = artistaSer.save(artista);

    ArtistaResponse response = new ArtistaResponse(artistaCreado.getId(), artistaCreado.getNombre(),
        artistaCreado.getPais());

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(artistaCreado.getId())
        .toUri();

    return ResponseEntity.created(uri).body(response);
  }

  @GetMapping("/{id}")
  public ArtistaResponse getById(@PathVariable Long id) {

    Artista artista = artistaSer.findById(id);
    ArtistaResponse response = new ArtistaResponse(artista.getId(), artista.getNombre(), artista.getPais());

    return response;

  }

  @PutMapping("/{id}")
  public ArtistaResponse update(@PathVariable Long id, @Valid @RequestBody ArtistaRequest request) {

    Artista artista = new Artista();
    artista.setNombre(request.nombre());
    artista.setPais(request.pais());

    Artista artistaCreado = artistaSer.update(id, artista);

    ArtistaResponse response = new ArtistaResponse(artistaCreado.getId(), artistaCreado.getNombre(),
        artistaCreado.getPais());

    return response;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    artistaSer.delete(id);
    return ResponseEntity.noContent().build();
  }

}
