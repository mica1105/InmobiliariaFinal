package com.mika.inmobiliariafinal.modelo;

import java.io.Serializable;

public class Contrato implements Serializable {
    private int id;
    private String fechaInicio;
    private String fechaFin;
    private double precio;
    private int inmuebleId;
    private Inmueble inmueble;
    private int inquilinoId;
    private Inquilino inquilino;

    public Contrato(int id, String fechaInicio, String fechaFin, double precio, int inmuebleId, Inmueble inmueble, int inquilinoId, Inquilino inquilino) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.inmuebleId = inmuebleId;
        this.inmueble= inmueble;
        this.inquilinoId = inquilinoId;
        this.inquilino= inquilino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(int inmuebleId) {
        this.inmuebleId = inmuebleId;
    }

    public int getInquilinoId() {
        return inquilinoId;
    }

    public void setInquilinoId(int inquilinoId) {
        this.inquilinoId = inquilinoId;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }
}
