package com.mika.inmobiliariafinal.modelo;

import java.io.Serializable;

public class Inquilino implements Serializable {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String lugarTrabajo;
    private String telefono;
    private String email;
    private String nombreGarante;
    private String dniGarante;
    private String telefonoGarante;

    public Inquilino(int id, String nombre, String apellido, String dni, String lugarTrabajo, String telefono, String email,
                     String nombreGarante, String dniGarante, String telefonoGarante) {
        this.id=id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.lugarTrabajo = lugarTrabajo;
        this.telefono = telefono;
        this.email = email;
        this.nombreGarante = nombreGarante;
        this.dniGarante = dniGarante;
        this.telefonoGarante = telefonoGarante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarDeTrabajo) {
        this.lugarTrabajo = lugarDeTrabajo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreGarante() {
        return nombreGarante;
    }

    public void setNombreGarante(String nombreGarante) {
        this.nombreGarante = nombreGarante;
    }

    public String getDniGarante() {
        return dniGarante;
    }

    public void setDniGarante(String dniGarante) {
        this.dniGarante = dniGarante;
    }

    public String getTelefonoGarante() {
        return telefonoGarante;
    }

    public void setTelefonoGarante(String telefonoGarante) {
        this.telefonoGarante = telefonoGarante;
    }
}
