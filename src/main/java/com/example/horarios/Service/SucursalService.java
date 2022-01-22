package com.example.horarios.Service;

import com.example.horarios.Entidades.Empleado;
import com.example.horarios.Entidades.Planificacion;
import com.example.horarios.Entidades.Sucursal;
import com.example.horarios.Errores.ErrorServicio;
import com.example.horarios.Repositorio.SucursalRepositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SucursalService {

    @Autowired
    SucursalRepositorio sucursalrepositorio;
    
    
@Transactional
    public void agregar(String nombre, Planificacion planificacion) throws ErrorServicio {

        validar(nombre,planificacion);

        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(nombre);
        sucursal.setPlanificacion(planificacion);
        sucursalrepositorio.save(sucursal);

    }
@Transactional
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
    
    
    @Transactional
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


    @Transactional
    public List<Sucursal> findAll() throws Exception{
    try {
        List<Sucursal> sucursales = sucursalrepositorio.findAll();
        return sucursales;
    }catch (Exception e){
        throw  new Exception(e.getMessage());
    }
    }

    @Transactional
    public Sucursal findById(long id) throws Exception{
        try {
            Sucursal sucursal = sucursalrepositorio.findById(id).get();
            return sucursal;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Empleado> findAllEmpleados(long id) throws Exception{
        try {
            Sucursal sucursal = sucursalrepositorio.findById(id).get();
            List<Empleado> empleados = sucursal.getEmpleados();
            return empleados;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }


    @Transactional
    public Planificacion getPlanificacion(long id) throws Exception{
        try {
            Sucursal sucursal = sucursalrepositorio.findById(id).get();
            Planificacion planificacion = sucursal.getPlanificacion();
            return planificacion;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }


    @Transactional
    public void agregarEmpleado(Empleado emp, long id) throws Exception{
        try {
            Sucursal sucursal = sucursalrepositorio.findById(id).get();
            sucursal.addEmpleado(emp);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
    
       @Transactional
       public void darDeBaja(Long id, String nombre) throws ErrorServicio {

        Optional<Sucursal> respuesta = sucursalrepositorio.findById(id);
        if (respuesta.isPresent()) {
            Sucursal sucursal = respuesta.get();
            sucursal.setAlta(false);
            sucursalrepositorio.save(sucursal);
        } else {
            throw new ErrorServicio("No se encontro la sucursal buscado");
        }

    }

}

