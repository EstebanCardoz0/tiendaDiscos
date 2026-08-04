package com.estebancardozo.tiendadiscos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String pais;

    @Override
    public boolean equals(Object o) {
        if (this == 0) return true;
        if (!(o instanceof Artista)) return false;
        Artista artista = (Artista) o;
        return id != null && id.equals(artista.id)
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
