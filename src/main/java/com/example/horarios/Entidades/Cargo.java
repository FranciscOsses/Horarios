
package com.example.horarios.Entidades;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToMany;

public class Cargo {
    
    private String nombreCargo;
    
    @ManyToMany
    private List<Empleado>empleado=new ArrayList<>();

    public Cargo() {
    }
    

    public Cargo(String nombreCargo, List<Empleado> empleado) {
        this.nombreCargo = nombreCargo;
        this.empleado = empleado;
    }
    
    
    public ArrayList<Empleado> getEmpleado() {
        return (ArrayList<Empleado>) empleado;
    }

    public void setEmpleado(ArrayList<Empleado> empleado) {
        this.empleado = empleado;
    }
    
    

    public Cargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }
    
    
    
}