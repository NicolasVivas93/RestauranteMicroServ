
package com.restaurante.servicioplatos.service;

import com.restaurante.servicioplatos.dto.PlatoDTO;
import com.restaurante.servicioplatos.model.Ingrediente;
import com.restaurante.servicioplatos.model.Plato;
import com.restaurante.servicioplatos.repository.IPlatoRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlatoService implements IPlatoService {

    @Autowired
    private IPlatoRepository platoRepo;
    
    @Autowired
    private RestTemplate apiConsumir;

    @Autowired
    private PlatoDTO platoDto;
    
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
    public List<PlatoDTO> getPlatosConIngred() {
        List<PlatoDTO> listPlatosDto = new ArrayList<>();

        List<Plato> listaPlatos = this.getPlatos();

        for(Plato plato : listaPlatos) {
            List<String> listIngred = this.getIngrXPlato(plato.getNombre());
            PlatoDTO platoDto = new PlatoDTO(); 

            if (platoDto != null) {
                platoDto.setNombre(plato.getNombre());
                platoDto.setDescripcion(plato.getDescripcion());
                platoDto.setPrecio(plato.getPrecio());
                platoDto.setListaIngredientes(listIngred);
            }
            
            listPlatosDto.add(platoDto);

        }

        return listPlatosDto;
    }

    @Override
    public List<String> getIngrXPlato(String nombrePlato) {
        List<String> listadoIngredientes = new ArrayList<>();

        ResponseEntity<List<Ingrediente>> response = apiConsumir.exchange("http://localhost:9002/ingrediente/traerPorPlato/" + nombrePlato, HttpMethod.GET, null, new ParameterizedTypeReference<List<Ingrediente>>() {});

        List<Ingrediente> ingredientes = response.getBody();

        for(Ingrediente ingrediente : ingredientes) {
            listadoIngredientes.add(ingrediente.getNombre());
        }

        return listadoIngredientes;       
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
