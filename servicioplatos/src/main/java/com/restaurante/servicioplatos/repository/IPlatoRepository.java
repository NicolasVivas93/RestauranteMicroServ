
package com.restaurante.servicioplatos.repository;

import com.restaurante.servicioplatos.model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlatoRepository extends JpaRepository<Plato, Long> {
    
}
