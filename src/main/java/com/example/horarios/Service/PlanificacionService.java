package com.example.horarios.Service;

import com.example.horarios.Entidades.Planificacion;
import com.example.horarios.Entidades.Sucursal;
import com.example.horarios.Errores.ErrorServicio;
import com.example.horarios.Repositorio.PlanificacionRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class PlanificacionService {

    @Autowired
    PlanificacionRepositorio planificacionrepositorio;

    @Transactional
    public void Agregar(int CantHoras, Sucursal sucursal) throws ErrorServicio {

        validar(CantHoras, sucursal);

        Planificacion planificacion = new Planificacion();
        planificacion.setCantHoras(CantHoras);

        planificacion.setSucursal(sucursal);
    }

    @Transactional
    public void validar(int CantHoras, Sucursal sucursal) throws ErrorServicio {

        try {
            if (CantHoras <= 0) {
                throw new ErrorServicio("La cantidad de horas no puede ser nula");
            }
            if (sucursal == null) {
                throw new ErrorServicio("El empleado debe tener al menos una sucursal");
            }

        } catch (Exception e) {
            throw new ErrorServicio("Ocurrio un error,intentelo nuevamente");
        }

    }

    @Transactional
    public void modificar(Long id, int CantHoras, Sucursal sucursal) throws ErrorServicio {

        validar(CantHoras, sucursal);

        Optional<Planificacion> respuesta = planificacionrepositorio.findById(id);
        if (respuesta.isPresent()) {
            Planificacion planificacion = respuesta.get();
            planificacion.setCantHoras(CantHoras);
            planificacion.setSucursal(sucursal);
            planificacionrepositorio.save(planificacion);
        } else {
            throw new ErrorServicio("No se encontro el Libro buscado");
        }
    }
}
