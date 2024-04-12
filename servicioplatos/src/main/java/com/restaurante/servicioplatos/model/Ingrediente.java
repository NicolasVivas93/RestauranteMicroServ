
package com.restaurante.servicioplatos.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class Ingrediente {
    
    private Long id;
    private String nombre;
    private List<String> listaPlatos;
}
