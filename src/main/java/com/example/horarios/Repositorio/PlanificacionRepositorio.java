package com.example.horarios.Repositorio;

import com.example.horarios.Entidades.Planificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanificacionRepositorio extends JpaRepository<Planificacion, Long> {
}
