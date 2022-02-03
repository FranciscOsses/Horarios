
package com.example.horarios.Repositorio;

import com.example.horarios.Entidades.Empleado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
    
    
//    @Query("SELECT c FROM empleado c WHERE c.nombre LIKE :q or c.id LIKE :q")
//    public List<Empleado> findAllByQ(@Param("q") String q);
    
}
