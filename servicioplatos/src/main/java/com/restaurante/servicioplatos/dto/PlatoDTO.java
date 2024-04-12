package com.restaurante.servicioplatos.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Component
public class PlatoDTO {

    //private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private List<String> listaIngredientes;

}
