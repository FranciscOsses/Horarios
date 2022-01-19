
package com.example.horarios.Repositorio;

import com.example.horarios.Entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
    
}
