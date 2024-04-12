
package com.restaurante.servicioingredientes.controller;

import com.restaurante.servicioingredientes.model.Ingrediente;
import com.restaurante.servicioingredientes.service.IIngredienteService;
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
@RequestMapping("/ingrediente")
public class IngredienteController {
    
    @Autowired
    private IIngredienteService ingredienteServ;
    
    // Este create es temporal, debido a que necesitamos modificarlo 
    // para traer los platos
    @PostMapping("/crear")
    public String createIngrediente(@RequestBody Ingrediente ingrediente) {
        ingredienteServ.createIngrediente(ingrediente);
        return "Ingrediente creado";
    }
    
    @GetMapping("/traer")
    public List<Ingrediente> getIngredientes() {
        return ingredienteServ.getIngredientes();
    }
    
    @GetMapping("/traer/{id}")
    public Ingrediente getIngrediente(@PathVariable Long id) {
        return ingredienteServ.getIngrediente(id);
    }
    
    @GetMapping("/traerPorPlato/{nombrePlato}")
    public List<Ingrediente> getIngredientePorPlato(@PathVariable String nombrePlato) {
        return ingredienteServ.buscarPorPlato(nombrePlato);
    }
    
    
    @PutMapping("/editar")
    public Ingrediente editIngrediente(@RequestBody Ingrediente ingredModif) {
        ingredienteServ.editIngrediente(ingredModif);
        return ingredienteServ.getIngrediente(ingredModif.getId());
    }
    
    @DeleteMapping("/borrar/{id}")
    public String deleteIngrediente(@PathVariable Long id) {
        ingredienteServ.deleteIngrediente(id);
        return "Ingrediente eliminado";
    }
        
}
