package com.mika.inmobiliariafinal.modelo;

public class Propietario {
    private int id;
    private String dni;
    private  String apellido;
    private String nombre;
    private String telefono;
    private int estado;
    private String email;
    private String clave;

    public Propietario(int id,String dni, String apellido, String nombre, String telefono,int estado, String mail, String password) {
        this.id=id;
        this.dni= dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono= telefono;
        this.estado= estado;
        this.email = mail;
        this.clave = password;
    }
    public Propietario(String dni, String apellido, String nombre, String telefono, String mail, String password) {
        this.dni= dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono= telefono;
        this.email = mail;
        this.clave = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
