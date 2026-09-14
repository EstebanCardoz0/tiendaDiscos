package com.estebancardozo.tiendadiscos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estebancardozo.tiendadiscos.dto.ArtistaRequest;
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
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ProblemDetail;
import io.swagger.v3.oas.annotations.headers.Header;

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
        .map(artista -> toResponse(artista)).toList();

  }

  @ApiResponses({
      @ApiResponse(responseCode = "201", description = "Artista creado", headers = @Header(name = "Location", description = "URI del artista recien creado", schema = @Schema(type = "string"))),
      @ApiResponse(responseCode = "400", description = "Datos invalidos", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = ProblemDetail.class)))

  })

  @PostMapping
  public ResponseEntity<ArtistaResponse> create(@Valid @RequestBody ArtistaRequest request) {

    Artista artista = new Artista();
    artista.setNombre(request.nombre());
    artista.setPais(request.pais());

    Artista artistaCreado = artistaSer.save(artista);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(artistaCreado.getId())
        .toUri();

    return ResponseEntity.created(uri).body(this.toResponse(artistaCreado));
  }

  @ApiResponses({ @ApiResponse(responseCode = "200", description = "Artista encontrado"),
      @ApiResponse(responseCode = "404", description = "No existe un artista con ese id", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = ProblemDetail.class)))
  })
  @GetMapping("/{id}")
  public ArtistaResponse getById(@PathVariable Long id) {

    Artista artista = artistaSer.findById(id);

    return this.toResponse(artista);

  }

  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Artista actualizado"),
      @ApiResponse(responseCode = "400", description = "Datos invalidos", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = ProblemDetail.class))),
      @ApiResponse(responseCode = "404", description = "No existe un artista con ese id", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = ProblemDetail.class)))
  })
  @PutMapping("/{id}")

  public ArtistaResponse update(@PathVariable Long id, @Valid @RequestBody ArtistaRequest request) {

    Artista artista = new Artista();
    artista.setNombre(request.nombre());
    artista.setPais(request.pais());

    Artista artistaActualizado = artistaSer.update(id, artista);

    return this.toResponse(artistaActualizado);
  }

  @ApiResponses({ @ApiResponse(responseCode = "204", description = "Artista eliminado"),
      @ApiResponse(responseCode = "404", description = "Artista no encontrado", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = ProblemDetail.class))) })
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    artistaSer.delete(id);
    return ResponseEntity.noContent().build();
  }

  private ArtistaResponse toResponse(Artista artista) {

    ArtistaResponse response = new ArtistaResponse(artista.getId(), artista.getNombre(), artista.getPais());

    return response;

  }
}
