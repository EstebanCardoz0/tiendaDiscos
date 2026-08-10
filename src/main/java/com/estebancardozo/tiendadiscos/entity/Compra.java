package com.estebancardozo.tiendadiscos.entity;

import java.sql.Date;


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
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Compra {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private Date fecha;
  @Column(nullable = false, precision = 10, scale = 2)
  private BigDecimal monto;
  @ManyToOne
  @JoinColumn(nullable = false, name = "cliente_id")
  private Cliente cliente;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Compra))
      return false;
    Compra compra = (Compra) o;
    return id != null && id.equals(compra.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

}
