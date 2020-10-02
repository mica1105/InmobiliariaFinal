package com.mika.inmobiliariafinal.modelo;

import java.io.Serializable;

public class Propiedad implements Serializable {
    private int foto;
    private String domicilio;
    private int ambientes;
    private String tipo;
    private String uso;
    private double precio;
    private boolean disponible;

    public Propiedad(int foto, String domicilio, int ambientes, String tipo, String uso, float precio, boolean disponible) {
        this.foto= foto;
        this.domicilio = domicilio;
        this.ambientes = ambientes;
        this.tipo = tipo;
        this.uso = uso;
        this.precio = precio;
        this.disponible = disponible;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(int ambientes) {
        this.ambientes = ambientes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public boolean isDisponible() {
        return disponible;
    }
}
