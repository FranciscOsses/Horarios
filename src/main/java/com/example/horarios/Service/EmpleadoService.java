package com.example.horarios.Service;

import com.example.horarios.Entidades.Cargo;
import com.example.horarios.Entidades.Empleado;
import com.example.horarios.Entidades.Sucursal;
import com.example.horarios.Errores.ErrorServicio;
import com.example.horarios.Repositorio.EmpleadoRepositorio;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpleadoService {

    @Autowired
    EmpleadoRepositorio empleadorepositorio;

    public void Agregar(String nombre, int CargaHoraria, Date diaFranco, Cargo cargo, Sucursal sucursal) throws ErrorServicio {

        validar(nombre, CargaHoraria, diaFranco, cargo, sucursal);

        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setCargaHoraria(CargaHoraria);
        empleado.setCargo((List<Cargo>) cargo);
        empleado.setSucursal((List<Sucursal>) sucursal);
        empleado.setAlta(true);
        empleadorepositorio.save(empleado);

    }

    public void validar(String nombre, int CargaHoraria, Date diaFranco, Cargo cargo, Sucursal sucursal) throws ErrorServicio {

        try {
            if (nombre == null || nombre.isEmpty()) {
                throw new ErrorServicio("El nombre del empleado no puede ser nulo");
            }
            if (CargaHoraria <= 0) {
                throw new ErrorServicio("La carga horaria no puede ser nula");
            }
            if (diaFranco == null) {
                throw new ErrorServicio("El dia de franco no puede ser nulo");
            }
             if (cargo == null) {
                throw new ErrorServicio("El empleado debe tener al menos un cargo");
            }
             if (sucursal == null) {
                throw new ErrorServicio("El empleado debe tener al menos una sucursal");
            }
            
        } catch (Exception e) {
            throw new ErrorServicio("Ocurrio un error,intentelo nuevamente");
        }

    }

    public void modificar(Long id, String nombre, int CargaHoraria, Date diaFranco, Cargo cargo, Sucursal sucursal) throws ErrorServicio {

        validar(nombre, CargaHoraria, diaFranco, cargo, sucursal);

        Optional<Empleado> respuesta = empleadorepositorio.findById(id);
        if (respuesta.isPresent()) {
            Empleado empleado = respuesta.get();
            empleado.setNombre(nombre);
            empleado.setCargaHoraria(CargaHoraria);
            empleado.setDiaFranco(diaFranco);
            empleado.setCargo((List<Cargo>) cargo);
            empleado.setSucursal((List<Sucursal>) sucursal);
            empleadorepositorio.save(empleado);

        } else {
            throw new ErrorServicio("No se encontro el Libro buscado");
        }

    }
    
       public void DarDeBaja(Long id, String nombre) throws ErrorServicio {

        Optional<Empleado> respuesta = empleadorepositorio.findById(id);
        if (respuesta.isPresent()) {
            Empleado empleado = respuesta.get();
            empleado.setAlta(false);
            empleadorepositorio.save(empleado);
        } else {
            throw new ErrorServicio("No se encontro el Empleado buscado");
        }

    }
    
    
   
}
