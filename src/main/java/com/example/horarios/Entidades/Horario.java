package com.example.horarios.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Horario {

    public int horaEntrada;
    public int horaSalida;
    public Empleado empleadoAsignado;
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
