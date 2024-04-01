
package com.restaurante.servicioingredientes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Plato {
     
    private Long numeroPlato;
    private String nombre;
    private Double precio;
    private String descripcion;
}
