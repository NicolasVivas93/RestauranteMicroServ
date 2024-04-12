
package com.restaurante.servicioplatos.service;

import com.restaurante.servicioplatos.dto.PlatoDTO;
import com.restaurante.servicioplatos.model.Plato;
import java.util.List;


public interface IPlatoService {
    
    public void createPlato(Plato plato);
    
    public List<Plato> getPlatos();
    public Plato getPlato(Long id);
    public List<PlatoDTO> getPlatosConIngred();
    public List<String> getIngrXPlato(String nombrePlato);

    
    public void editPlato(Plato platoModif);
    
    public void deletePlato(Long id);  
}
