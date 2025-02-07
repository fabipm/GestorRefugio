/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Entidad;

import java.util.Date;

/**
 *
 * @author RAUL
 */
public class clsEAnimal {
    private int idAnimal;
    private String nombre;
    private Date fecha;
    public static enum Estado{
    activo,
    inactivo
}
    private Estado estado;
    public static enum Genero {
    macho,
    hembra
    }
    private Genero genero;
    public static enum Tipo{
    perro,
    gato
    }
    private Tipo tipo;
    private String foto;
    private String raza;
    private String edad;

    public clsEAnimal(int idAnimal, String nombre, Date fecha, Estado estado, Genero genero, Tipo tipo, String foto, String raza, String edad) {
        this.idAnimal = idAnimal;
        this.nombre = nombre;
        this.fecha = fecha;
        this.estado = estado;
        this.genero = genero;
        this.tipo = tipo;
        this.foto = foto;
        this.raza = raza;
        this.edad = edad;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
}