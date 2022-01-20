package com.example.horarios.Service;

import com.example.horarios.Entidades.Cargo;
import com.example.horarios.Entidades.Empleado;
import com.example.horarios.Entidades.Sucursal;
import com.example.horarios.Errores.ErrorServicio;
import com.example.horarios.Repositorio.CargoRepositorio;
import com.example.horarios.Repositorio.EmpleadoRepositorio;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.horarios.Repositorio.SucursalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepositorio empleadoRepositorio;
    @Autowired
    CargoRepositorio cargoRepositorio;
    @Autowired
    SucursalRepositorio sucursalRepositorio;

    @Transactional
    public void agregar(String nombre, int cargaHoraria, Date diaFranco, long idCargo, long idSucursal) throws ErrorServicio {

        Cargo cargo = cargoRepositorio.findById(idCargo).get();
        Sucursal sucursal = sucursalRepositorio.findById(idSucursal).get();


        validar(nombre, cargaHoraria, diaFranco, cargo, sucursal);

        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setCargaHoraria(cargaHoraria);
        empleado.setCargo((List<Cargo>) cargo);
        empleado.setSucursal((List<Sucursal>) sucursal);
        empleado.setAlta(true);
        empleadoRepositorio.save(empleado);

    }

    @Transactional
    public void validar(String nombre, int cargaHoraria, Date diaFranco, Cargo cargo, Sucursal sucursal) throws ErrorServicio {

        try {
            if (nombre == null || nombre.isEmpty()) {
                throw new ErrorServicio("El nombre del empleado no puede ser nulo");
            }
            if (cargaHoraria <= 0) {
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

    @Transactional
    public void modificar(Long id, String nombre, int cargaHoraria, Date diaFranco, long idCargo, long idSucursal) throws ErrorServicio {

        Cargo cargo = cargoRepositorio.findById(idCargo).get();
        Sucursal sucursal = sucursalRepositorio.findById(idSucursal).get();


        validar(nombre, cargaHoraria, diaFranco, cargo, sucursal);

        Optional<Empleado> respuesta = empleadoRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Empleado empleado = respuesta.get();
            empleado.setNombre(nombre);
            empleado.setCargaHoraria(cargaHoraria);
            empleado.setDiaFranco(diaFranco);
            empleado.setCargo((List<Cargo>) cargo);
            empleado.setSucursal((List<Sucursal>) sucursal);
            empleadoRepositorio.save(empleado);

        } else {
            throw new ErrorServicio("No se encontro el Libro buscado");
        }

    }
    
    @Transactional
       public void darDeBaja(Long id, String nombre) throws ErrorServicio {

        Optional<Empleado> respuesta = empleadoRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Empleado empleado = respuesta.get();
            empleado.setAlta(false);
            empleadoRepositorio.save(empleado);
        } else {
            throw new ErrorServicio("No se encontro el Empleado buscado");
        }

    }
    
    
   
}
