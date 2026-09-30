package com.estebancardozo.tiendadiscos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ProblemDetail;
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

import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api/albumes")
public class AlbumController {

    private final AlbumService albumser;

    public AlbumController(AlbumService albumService) {
        this.albumser = albumService;
    }

    @GetMapping("/{id}")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Album encontrado"),
            @ApiResponse(responseCode = "404", description = "No existe un album con ese id", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = ProblemDetail.class))) })
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
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Album creado exitosamente", headers = @Header(name = "Location", description = "URL del album creado", schema = @Schema(type = "string"))),
            @ApiResponse(responseCode = "400", description = "faltan campos obligatorios o son inválidos", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = ProblemDetail.class))),
            @ApiResponse(responseCode = "422", description = "El artistaId proporcionado no coincide con ningun artista", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = ProblemDetail.class))), })
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
    @ApiResponses({ @ApiResponse(responseCode = "204", description = "Se eliminó el album correctamente"),
            @ApiResponse(responseCode = "404", description = "No se encontró el album con ese id", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = ProblemDetail.class))) })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        albumser.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Album actualizado"),

          @ApiResponse(responseCode = "404", description = "No existe un album con ese id", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = ProblemDetail.class))),
            @ApiResponse(responseCode = "400", description = "faltan campos obligatorios o son inválidos", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = ProblemDetail.class))),
            @ApiResponse(responseCode = "422", description = "El artistaId proporcionado no coincide con ningun artista", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = ProblemDetail.class))) })
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
