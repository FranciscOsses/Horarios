
package com.example.horarios.Controladores;

import com.example.horarios.Entidades.Empleado;
import com.example.horarios.Entidades.Sucursal;
import com.example.horarios.Errores.ErrorServicio;
import com.example.horarios.Service.EmpleadoService;
import com.example.horarios.Service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpleadoControlador {

    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    SucursalService sucursalService;

    @GetMapping("/sucursal/{id}/agregarEmpleado")
    public String agregar(){
        return "agregarEmpleado";
    }

    @PostMapping("/sucursal/{id}/agregarEmpleado")
    public String agregarEmpleado(String nombre, int cargaHoraria, String diaFranco, long idCargo, long idSucursal){
        try {
            Empleado emp = empleadoService.agregar(nombre, cargaHoraria, diaFranco, idCargo, idSucursal);
            sucursalService.agregarEmpleado(emp, idSucursal);
            return "empleados";
        } catch (ErrorServicio e) {
            e.printStackTrace();
            return "error";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }
}
