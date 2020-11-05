package com.mika.inmobiliariafinal.modelo;

import java.io.Serializable;

public class Pago implements Serializable {
    private int id;
    private int nroPago;
    private String fecha;
    private double importe;
    private int contratoId;

    public Pago(int id, int nroPago, String fecha, double importe, int contratoId) {
        this.id = id;
        this.nroPago = nroPago;
        this.fecha = fecha;
        this.importe = importe;
        this.contratoId = contratoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPago() {
        return nroPago;
    }

    public void setPago(int nroPago) {
        this.nroPago = nroPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }
}
