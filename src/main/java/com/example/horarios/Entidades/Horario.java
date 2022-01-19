package com.example.horarios.Entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public int horaEntrada;
    public int horaSalida;
    @ManyToOne
    public Empleado empleadoAsignado;
    @OneToMany
    public List<Dia> dias = new ArrayList<>();


    public Horario() {
    }

    public Horario(int horaEntrada, int horaSalida) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }
}
