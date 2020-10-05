package com.mika.inmobiliariafinal.modelo;

import java.io.Serializable;

public class Pago implements Serializable {
    private int id;
    private int pago;
    private String fecha;
    private double importe;
    private Contrato contrato;

    public Pago(int id, int pago, String fecha, double importe, Contrato contrato) {
        this.id = id;
        this.pago = pago;
        this.fecha = fecha;
        this.importe = importe;
        this.contrato = contrato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
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

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
