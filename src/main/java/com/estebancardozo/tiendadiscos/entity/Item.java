package com.estebancardozo.tiendadiscos.entity;

import java.math.BigDecimal;

import jakarta.persistence.CheckConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(check = { @CheckConstraint(constraint = "cantidad >=1"), @CheckConstraint(constraint = "precio_unitario >=0") })
@NoArgsConstructor
@AllArgsConstructor
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private Integer cantidad;
  @Column(nullable = false, precision = 10, scale = 2)
  private BigDecimal precioUnitario;
  @ManyToOne
  @JoinColumn(name = "compra_id", nullable = false)
  private Compra compra;
  @ManyToOne
  @JoinColumn(name = "edicion_id", nullable = false)
  private Edicion edicion;

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Item))
      return false;
    Item item = (Item) o;
    return id != null && id.equals(item.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

}
