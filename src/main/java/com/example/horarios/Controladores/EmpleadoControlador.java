
package com.example.horarios.Controladores;

import com.example.horarios.Entidades.Empleado;
import com.example.horarios.Entidades.Sucursal;
import com.example.horarios.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmpleadoControlador {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/sucursal/{id}/agregarEmpleado")
    public String agregar(){
        return "agregarEmpleado";
    }


}
