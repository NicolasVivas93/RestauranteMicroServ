
package com.restaurante.servicioingredientes.repository;

import com.restaurante.servicioingredientes.model.Ingrediente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredienteRepository extends JpaRepository<Ingrediente, Long> {
    
    @Query(value = "SELECT * FROM ingrediente WHERE id IN (SELECT id_ingrediente FROM platos_para_ingrediente WHERE lista_platos = :nombrePlato)", nativeQuery = true)
    public List<Ingrediente> findByPlato(String nombrePlato);
    
    
}
