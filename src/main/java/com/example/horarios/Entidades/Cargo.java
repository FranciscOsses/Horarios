
package com.example.horarios.Entidades;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String nombreCargo;
    
    @ManyToMany
    public List<Empleado> empleados = new ArrayList<>();

    public Cargo() {
    }


    public Cargo(long id, String nombreCargo, List<Empleado> empleados) {
        this.id = id;
        this.nombreCargo = nombreCargo;
        this.empleados = empleados;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}
