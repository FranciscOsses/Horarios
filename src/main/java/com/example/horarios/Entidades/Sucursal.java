package com.example.horarios.Entidades;

public class Sucursal {


    public long id;
    public String nombre;

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
}
