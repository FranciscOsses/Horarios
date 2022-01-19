package com.example.horarios.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Dia {


    public String nombre;
    public int horas;
    public int horaInicio;
    public int horaFin;
    public List<Horario> horarios = new ArrayList<>();


    public Dia() {
    }

    public Dia(String nombre, int horas, int horaInicio, int horaFin) {
        this.nombre = nombre;
        this.horas = horas;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}
