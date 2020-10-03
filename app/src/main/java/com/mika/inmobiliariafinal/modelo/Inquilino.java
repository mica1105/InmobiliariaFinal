package com.mika.inmobiliariafinal.modelo;

import java.io.Serializable;

public class Inquilino implements Serializable {
    private String nombre;
    private String apellido;
    private String dni;
    private String lugarDeTrabajo;
    private String telefono;
    private String email;
    private String nombreGarante;
    private String dniGarante;
    private String telGarante;

    public Inquilino(String nombre, String apellido, String dni, String lugarDeTrabajo, String telefono, String email,
                     String nombreGarante, String dniGarante, String telGarante) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.lugarDeTrabajo = lugarDeTrabajo;
        this.telefono = telefono;
        this.email = email;
        this.nombreGarante = nombreGarante;
        this.dniGarante = dniGarante;
        this.telGarante = telGarante;
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

    public String getLugarDeTrabajo() {
        return lugarDeTrabajo;
    }

    public void setLugarDeTrabajo(String lugarDeTrabajo) {
        this.lugarDeTrabajo = lugarDeTrabajo;
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

    public String getTelGarante() {
        return telGarante;
    }

    public void setTelGarante(String telGarante) {
        this.telGarante = telGarante;
    }
}
