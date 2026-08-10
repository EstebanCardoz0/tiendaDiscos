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
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true, nullable = false)
  private String user;
  @Column(nullable = false)
  private String pass;

  @Override
  public boolean equals(Object i) {
    if (this == i)
      return true;
    if (!(i instanceof Admin))
      return false;
    Admin admin = (Admin) i;
    return id != null && id.equals(admin.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

}
