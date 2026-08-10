package com.estebancardozo.tiendadiscos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String nombre;
  @Column(nullable = false)
  private String apellido;
  @Column(nullable = false, unique = true)
  private String dni;
  @Column(nullable = false, unique = true)
  private String mail;
  @Column(nullable = false, unique = true)
  private String user;
  @Column(nullable = false)
  private String pass;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Cliente))
      return false;
    Cliente cliente = (Cliente) o;
    return id != null && id.equals(cliente.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

}
