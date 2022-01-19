
package com.example.horarios.Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private Date diaFranco;
    private int CargaHoraria;
    private int HorasTrabajadas;
    private int HorasExtras;
    private boolean alta;
    
  
    @ManyToMany
    private List<Sucursal> sucursal=new ArrayList<>();
    @ManyToMany
    private List<Cargo> cargo =new ArrayList<>();
    
     

    public Empleado() {
    }

    public Empleado(long id, String nombre, Date diaFranco, int CargaHoraria, int HorasTrabajadas, int HorasExtras, boolean alta, ArrayList<Sucursal> sucursal, ArrayList<Cargo> cargo) {
        this.id = id;
        this.nombre = nombre;
        this.diaFranco = diaFranco;
        this.CargaHoraria = CargaHoraria;
        this.HorasTrabajadas = HorasTrabajadas;
        this.HorasExtras = HorasExtras;
        this.alta = alta;
        this.sucursal = sucursal;
        this.cargo = cargo;
    }

    


    public void setSucursal(ArrayList<Sucursal> sucursal) {
        this.sucursal = sucursal;
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

    public void setCargo(ArrayList<Cargo> cargo) {
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

    public Date getDiaFranco() {
        return diaFranco;
    }

    public void setDiaFranco(Date diaFranco) {
        this.diaFranco = diaFranco;
    }

    public int getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(int CargaHoraria) {
        this.CargaHoraria = CargaHoraria;
    }

    public int getHorasTrabajadas() {
        return HorasTrabajadas;
    }

    public void setHorasTrabajadas(int HorasTrabajadas) {
        this.HorasTrabajadas = HorasTrabajadas;
    }

    public int getHorasExtras() {
        return HorasExtras;
    }

    public void setHorasExtras(int HorasExtras) {
        this.HorasExtras = HorasExtras;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", diaFranco=" + diaFranco + ", CargaHoraria=" + CargaHoraria + ", HorasTrabajadas=" + HorasTrabajadas + ", HorasExtras=" + HorasExtras + ", alta=" + alta + '}';
    }
    
    
}
