
package com.example.horarios.Controladores;

import com.example.horarios.Entidades.Cargo;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@Controller
public class EmpleadoControlador {

    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    SucursalService sucursalService;

    @GetMapping("/sucursal/{id}/agregarEmpleado")
    public String agregar(Model model){
        List<Cargo> cargos = null;
        try {
            cargos = empleadoService.getAllCargos();
            model.addAttribute("cargos", cargos);
            return "agregarEmpleado";
        } catch (ErrorServicio e) {
            e.printStackTrace();
            return "error";
        }
        }

    @PostMapping("/sucursal/{id}/agregarEmpleado")
    public RedirectView agregarEmpleado(String nombre, int cargaHoraria, String diaFranco, long idCargo, @PathVariable("id") long idSucursal, Model model){
        try {
            Empleado emp = empleadoService.agregar(nombre, cargaHoraria, diaFranco, idCargo, idSucursal);
            sucursalService.agregarEmpleado(emp, idSucursal);
            List<Empleado> empleados = sucursalService.findAllEmpleados(idSucursal);
            model.addAttribute("sucursal",sucursalService.findById(idSucursal));
            model.addAttribute("empleados",empleados);
            return new RedirectView("/sucursal/"+idSucursal+"/empleados");
            //return "/empleados";
        } catch (ErrorServicio e) {
            e.printStackTrace();
            return new RedirectView("/error");
        } catch (Exception e) {
            e.printStackTrace();
            return new RedirectView("error");
        }

    }
}
