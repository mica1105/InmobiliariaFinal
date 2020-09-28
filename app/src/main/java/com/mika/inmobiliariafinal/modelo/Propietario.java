package com.mika.inmobiliariafinal.modelo;

public class Propietario {
    private String dni;
    private  String apellido;
    private String nombre;
    private String telefono;
    private String mail;
    private String password;

    public Propietario(String dni, String apellido, String nombre, String telefono, String mail, String password) {
        this.dni= dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono= telefono;
        this.mail = mail;
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
