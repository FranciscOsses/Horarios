package com.example.horarios.Entidades;

public class Planificacion {

    public long id;
    public int cantHoras;
    public Sucursal sucursal;

    public Planificacion() {
    }

    public Planificacion(long id, int cantHoras) {
        this.id = id;
        this.cantHoras = cantHoras;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }
}
