
package com.restaurante.servicioingredientes.service;

import com.restaurante.servicioingredientes.model.Ingrediente;
import java.util.List;


public interface IIngredienteService {
    
    public void createIngrediente(Ingrediente plato);
    
    public List<Ingrediente> getIngredientes();
    public Ingrediente getIngrediente(Long id);
    
    public void editIngrediente(Ingrediente platoModif);
    
    public void deleteIngrediente(Long id);
}
