package com.estebancardozo.tiendadiscos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estebancardozo.tiendadiscos.entity.Artista;
import com.estebancardozo.tiendadiscos.service.ArtistaService;

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

@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {

  private final ArtistaService artistaSer;

  public ArtistaController(ArtistaService artistaSer) {
    this.artistaSer = artistaSer;
  }

  @GetMapping
  public List<Artista> getAll() {
    return artistaSer.findAll();

  }

  @PostMapping
  public ResponseEntity<Artista> create(@RequestBody Artista artista) {

    Artista artistaCreado = artistaSer.save(artista);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(artistaCreado.getId())
        .toUri();

    return ResponseEntity.created(uri).body(artistaCreado);
  }

  @GetMapping("/{id}")
  public Artista getById(@PathVariable Long id) {

    return artistaSer.findById(id);

  }

  @PutMapping("/{id}")
  public Artista update(@PathVariable Long id, @RequestBody Artista artista) {

    return artistaSer.update(id, artista);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    artistaSer.delete(id);
    return ResponseEntity.noContent().build();
  }

}
