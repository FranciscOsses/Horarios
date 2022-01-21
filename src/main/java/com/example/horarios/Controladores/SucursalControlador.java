
package com.example.horarios.Controladores;

import com.example.horarios.Entidades.Empleado;
import com.example.horarios.Entidades.Planificacion;
import com.example.horarios.Entidades.Sucursal;
import com.example.horarios.Errores.ErrorServicio;
import com.example.horarios.Service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SucursalControlador {

    @Autowired
    SucursalService sucursalService;

    @GetMapping(value = "/")
    public String inicio(Model model){
        try {
            List<Sucursal> sucursales = sucursalService.findAll();
            model.addAttribute("sucursales", sucursales);
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping(value = "/sucursal/{id}")
    public String sucursal(Model model, @PathVariable("id") long id){
        try {
            Sucursal sucursal = sucursalService.findById(id);
            model.addAttribute("sucursal", sucursal);
            return "sucursal";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping(value = "/sucursal/{id}/empleados")
    public String empleados(Model model, @PathVariable("id") long id){
        try {
            List<Empleado> empleados = sucursalService.findAllEmpleados(id);
            Sucursal sucursal = sucursalService.findById(id);
            model.addAttribute("sucursal", sucursal);
            model.addAttribute("empleados", empleados);
            return "/empleados";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping(value = "/sucursal/{id}/horarios")
    public String horarios(Model model, @PathVariable("id") long id){
        try {
            Planificacion planificacion = sucursalService.getPlanificacion(id);
            model.addAttribute("planificacion", planificacion);
            return "/horarios";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
    
//    @GetMapping("/AgregarSucursal")
//    public String AgregarSucursal(@RequestParam String nombre, Planificacion planificacion) throws ErrorServicio{
//        sucursalService.agregar(nombre, planificacion);
//        return "AgregarSucursal.html";
//    }
//

}
