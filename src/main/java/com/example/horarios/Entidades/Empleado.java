
package com.example.horarios.Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String diaFranco;
    private int cargaHoraria;
    private int horasTrabajadas;
    private int horasExtras;
    private boolean alta;
    
  
    @ManyToMany
    private List<Sucursal> sucursal=new ArrayList<>();
    @ManyToMany
    private List<Cargo> cargo =new ArrayList<>();


    public Empleado() {
    }

    public Empleado(long id, String nombre, String diaFranco, int cargaHoraria, int horasTrabajadas, int horasExtras, boolean alta, List<Sucursal> sucursal, List<Cargo> cargo) {
        this.id = id;
        this.nombre = nombre;
        this.diaFranco = diaFranco;
        this.cargaHoraria = cargaHoraria;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtras = horasExtras;
        this.alta = alta;
        this.sucursal = sucursal;
        this.cargo = cargo;
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

    public String getDiaFranco() {
        return diaFranco;
    }

    public void setDiaFranco(String diaFranco) {
        this.diaFranco = diaFranco;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public List<Sucursal> getSucursal() {
        return sucursal;
    }

    public void setSucursal(List<Sucursal> sucursal) {
        this.sucursal = sucursal;
    }

    public List<Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(List<Cargo> cargo) {
        this.cargo = cargo;
    }

    public void addCargo(Cargo cargo) {
        this.cargo.add(cargo);
    }
}
