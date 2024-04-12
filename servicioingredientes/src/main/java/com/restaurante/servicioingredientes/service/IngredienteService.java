
package com.restaurante.servicioingredientes.service;

import com.restaurante.servicioingredientes.model.Ingrediente;
import com.restaurante.servicioingredientes.repository.IIngredienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService implements IIngredienteService {
    
    @Autowired
    private IIngredienteRepository ingredienteRepo;
    
    @Override
    public void createIngrediente(Ingrediente ingrediente) {
        ingredienteRepo.save(ingrediente);
    }

    @Override
    public List<Ingrediente> getIngredientes() {
        return ingredienteRepo.findAll();
    }

    @Override
    public Ingrediente getIngrediente(Long id) {
        return ingredienteRepo.findById(id).orElseThrow();
    }

    @Override
    public void editIngrediente(Ingrediente ingredienteModif) {
        ingredienteRepo.save(ingredienteModif);
    }

    @Override
    public void deleteIngrediente(Long id) {
        ingredienteRepo.deleteById(id);
    }

    @Override
    public List<Ingrediente> buscarPorPlato(String nombrePlato) {
        return ingredienteRepo.findByPlato(nombrePlato);
    }
    
}
