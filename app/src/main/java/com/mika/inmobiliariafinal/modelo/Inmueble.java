package com.mika.inmobiliariafinal.modelo;

import java.io.Serializable;

public class Inmueble implements Serializable {
    private int id;
    private String direccion;
    private String tipo;
    private int ambientes;
    private String uso;
    private double precio;
    private String imagen;
    private int propietarioId;
    private Propietario propietario;
    private int estado;

    public Inmueble(int id) {
        this.id = id;
    }

    public Inmueble(int id, String direccion, String tipo, int ambientes, String uso, double precio, String imagen, int propietarioId, Propietario propietario, int estado) {
        this.id = id;
        this.direccion = direccion;
        this.tipo = tipo;
        this.ambientes = ambientes;
        this.uso = uso;
        this.precio = precio;
        this.imagen= imagen;
        this.propietarioId= propietarioId;
        this.propietario = propietario;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(int ambientes) {
        this.ambientes = ambientes;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(int propietarioId) {
        this.propietarioId = propietarioId;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
