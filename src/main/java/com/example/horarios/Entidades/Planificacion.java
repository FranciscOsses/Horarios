package com.example.horarios.Entidades;

import javax.persistence.*;

@Entity
public class Planificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public int cantHoras;
    @OneToOne
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
