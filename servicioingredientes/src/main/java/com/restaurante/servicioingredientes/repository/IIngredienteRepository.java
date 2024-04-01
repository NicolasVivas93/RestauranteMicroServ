
package com.restaurante.servicioingredientes.repository;

import com.restaurante.servicioingredientes.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredienteRepository extends JpaRepository<Ingrediente, Long> {
    
}