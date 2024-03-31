
package com.restaurante.servicioplatos.service;

import com.restaurante.servicioplatos.model.Plato;
import com.restaurante.servicioplatos.repository.IPlatoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatoService implements IPlatoService {

    @Autowired
    private IPlatoRepository platoRepo;
    
    @Override
    public void createPlato(Plato plato) {
        platoRepo.save(plato);
    }

    @Override
    public List<Plato> getPlatos() {
        return platoRepo.findAll();
    }

    @Override
    public Plato getPlato(Long id) {
        return platoRepo.findById(id).orElseThrow();
    }

    @Override
    public void editPlato(Plato platoModif) {
        platoRepo.save(platoModif);
    }

    @Override
    public void deletePlato(Long id) {
        platoRepo.deleteById(id);
    }
    
}
