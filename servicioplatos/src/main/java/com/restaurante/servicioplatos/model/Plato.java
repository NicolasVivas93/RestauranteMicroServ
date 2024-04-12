
package com.restaurante.servicioplatos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

@Entity
public class Plato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long numeroPlato;
    
    private String nombre;
    private Double precio;
    private String descripcion;
}
