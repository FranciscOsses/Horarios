package com.example.horarios.Service;

import com.example.horarios.Entidades.Planificacion;
import com.example.horarios.Entidades.Sucursal;
import com.example.horarios.Errores.ErrorServicio;
import com.example.horarios.Repositorio.PlanificacionRepositorio;
import java.util.Optional;

import com.example.horarios.Repositorio.SucursalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PlanificacionService {

    @Autowired
    PlanificacionRepositorio planificacionrepositorio;
    @Autowired
    SucursalRepositorio sucursalRepositorio;

    @Transactional
    public void agregar(int cantHoras, long idSucursal) throws ErrorServicio {

        Sucursal sucursal = sucursalRepositorio.findById(idSucursal).get();

        validar(cantHoras, sucursal);

        Planificacion planificacion = new Planificacion();
        planificacion.setCantHoras(cantHoras);

        planificacion.setSucursal(sucursal);
    }

    @Transactional
    public void validar(int cantHoras, Sucursal sucursal) throws ErrorServicio {

        try {
            if (cantHoras <= 0) {
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
    public void modificar(Long id, int cantHoras, long idSucursal) throws ErrorServicio {

        Sucursal sucursal = sucursalRepositorio.findById(idSucursal).get();

        validar(cantHoras, sucursal);

        Optional<Planificacion> respuesta = planificacionrepositorio.findById(id);
        if (respuesta.isPresent()) {
            Planificacion planificacion = respuesta.get();
            planificacion.setCantHoras(cantHoras);
            planificacion.setSucursal(sucursal);
            planificacionrepositorio.save(planificacion);
        } else {
            throw new ErrorServicio("No se encontro el Libro buscado");
        }
    }
}
