package com.example.horarios.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {


    public long id;
    public String nombre;
    List<Empleado> empleados = new ArrayList<>();
    Planificacion planificacion;


    public Sucursal() {
    }

    public Sucursal(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Planificacion getPlanificacion() {
        return planificacion;
    }

    public void setPlanificacion(Planificacion planificacion) {
        this.planificacion = planificacion;
    }
}
