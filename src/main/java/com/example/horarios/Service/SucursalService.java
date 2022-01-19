package com.example.horarios.Service;

import com.example.horarios.Entidades.Planificacion;
import com.example.horarios.Entidades.Sucursal;
import com.example.horarios.Errores.ErrorServicio;
import com.example.horarios.Repositorio.SucursalRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class SucursalService {

    @Autowired
    SucursalRepositorio sucursalrepositorio;

    public void Agregar(String nombre, Planificacion planificacion) throws ErrorServicio {

        validar(nombre,planificacion);

        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(nombre);
        sucursal.setPlanificacion(planificacion);
        sucursalrepositorio.save(sucursal);

    }

    public void validar(String nombre,Planificacion planificacion) throws ErrorServicio {
        try {
            if (nombre == null || nombre.isEmpty()) {
                throw new ErrorServicio("El nombre del empleado no puede ser nulo");
            }
              if (planificacion == null || nombre.isEmpty()) {
                throw new ErrorServicio("La planificacion no puede ser nula");
            }
        } catch (Exception e) {
            throw new ErrorServicio("Ocurrio un error intentelo nuevamente mas tarde");
        }

    }
    
    
    
        public void modificar(Long id, String nombre,Planificacion planificacion) throws ErrorServicio {

        validar(nombre,planificacion);

        Optional<Sucursal> respuesta = sucursalrepositorio.findById(id);
        if (respuesta.isPresent()) {
            Sucursal sucursal = respuesta.get();
            sucursal.setNombre(nombre);
            sucursal.setPlanificacion(planificacion);
            sucursalrepositorio.save(sucursal);

        } else {
            throw new ErrorServicio("No se encontro el Libro buscado");
        }

    }
  
}

