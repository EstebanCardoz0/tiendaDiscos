package com.estebancardozo.tiendadiscos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estebancardozo.tiendadiscos.dto.AlbumRequest;
import com.estebancardozo.tiendadiscos.dto.AlbumResponse;
import com.estebancardozo.tiendadiscos.dto.ArtistaResponse;
import com.estebancardozo.tiendadiscos.entity.Album;
import com.estebancardozo.tiendadiscos.entity.Artista;
import com.estebancardozo.tiendadiscos.service.AlbumService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/albumes")
public class AlbumController {

    private final AlbumService albumser;

    public AlbumController(AlbumService albumService) {
        this.albumser = albumService;
    }

    @GetMapping("/{id}")
    public AlbumResponse getById(@PathVariable Long id) {

        Album album = albumser.findById(id);
        AlbumResponse albumResponse = toResponse(album);
        return albumResponse;

    }

    @GetMapping
    public List<AlbumResponse> getAll() {

        List<Album> albumes = albumser.findAll();

        List<AlbumResponse> responses = albumes.stream().map(album -> toResponse(album)).toList();

        return responses;
    }

    @PostMapping()
    public ResponseEntity<AlbumResponse> create(@Valid @RequestBody AlbumRequest album) {

        Album al = new Album();
        al.setTitulo(album.titulo());
        al.setAnio(album.anio());
        al.setDiscografica(album.discografica());
        al.setGenero(album.genero());

        Album alb = albumser.save(al, album.artistaId());

        AlbumResponse albumResponse = toResponse(alb);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alb.getId())
                .toUri();

        return ResponseEntity.created(location).body(albumResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        albumser.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public AlbumResponse update(@PathVariable Long id, @Valid @RequestBody AlbumRequest request) {

        Album album = new Album();
        album.setAnio(request.anio());
        album.setDiscografica(request.discografica());
        album.setGenero(request.genero());
        album.setTitulo(request.titulo());

        Album alb = albumser.update(id, album, request.artistaId());

        AlbumResponse response = toResponse(alb);

        return response;
    }

    private AlbumResponse toResponse(Album album) {

        Artista artista = album.getArtista();
        ArtistaResponse artistaResponse = new ArtistaResponse(artista.getId(), artista.getNombre(), artista.getPais());
        AlbumResponse albumResponse = new AlbumResponse(album.getId(), album.getTitulo(), artistaResponse,
                album.getAnio(), album.getDiscografica(), album.getGenero());

        return albumResponse;
    }

}
