
package com.restaurante.servicioplatos.controller;

import com.restaurante.servicioplatos.model.Plato;
import com.restaurante.servicioplatos.service.IPlatoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platos")
public class PlatoController {
    
    @Autowired
    private IPlatoService platoServ;
    
    @PostMapping("/crear")
    public String createPlato(@RequestBody Plato plato) {
        platoServ.createPlato(plato);
        return "Plato creado";
    }
    
    @GetMapping("/traer")
    public List<Plato> getPlatos() {
        return platoServ.getPlatos();
    }
    
    @GetMapping("/traer/{id}")
    public Plato getPlato(@PathVariable Long id) {
        return platoServ.getPlato(id);
    }
    
    @PutMapping("/editar")
    public Plato editPlato(@RequestBody Plato platoModif) {
        platoServ.editPlato(platoModif);
        return platoServ.getPlato(platoModif.getNumeroPlato());
    }
    
    @DeleteMapping("/borrar/{id}")
    public String deletePlato(@PathVariable Long id) {
        platoServ.deletePlato(id);
        return "Plato eliminado";
    }
    
}
