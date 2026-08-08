package com.estebancardozo.tiendadiscos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Edicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private Integer stock;
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal precio;
    @ManyToOne
    @JoinColumn(nullable = false, name = "album_id")
    private Album album;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edicion)) return false;
        Edicion edicion = (Edicion) o;
        return id != null && id.equals(edicion.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}


