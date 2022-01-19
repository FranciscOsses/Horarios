
package com.example.horarios.Service;

import com.example.horarios.Entidades.Empleado;
import com.example.horarios.Errores.ErrorServicio;
import com.example.horarios.Repositorio.EmpleadoRepositorio;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;


public class EmpleadoService {
    
    @Autowired
    EmpleadoRepositorio empleadorepositorio;
    
    
       public void Agregar(String nombre, int CargaHoraria, Date diaFranco) throws ErrorServicio{

       validar(nombre, CargaHoraria, diaFranco);

       Empleado empleado= new Empleado();
       empleado.setNombre(nombre);
       empleado.setCargaHoraria(CargaHoraria);
       empleado.setAlta(true);
       empleadorepositorio.save(empleado);

    }
    
    
        public void validar(String nombre, int CargaHoraria, Date diaFranco ) throws ErrorServicio{

        try{
                if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre del empleado no puede ser nulo");
        }
        if (CargaHoraria<=0) {
            throw new ErrorServicio("La carga horaria no puede ser nula");
        }
        if (diaFranco == null) {
            throw new ErrorServicio("");
        }
        }catch(Exception e){
            throw new ErrorServicio("Ocurrio un error,intentelo nuevamente");
        }
    
    }
    
    
}
