package com.estebancardozo.tiendadiscos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Album {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String titulo;
  @Column(nullable = false)
  private Integer anio;
  private String discografica;
  private String genero;
  @ManyToOne
  @JoinColumn(name = "artista_id", nullable = false)
  private Artista artista;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Album))
      return false;
    Album album = (Album) o;
    return id != null && id.equals(album.id);

  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
