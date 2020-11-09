package com.mika.inmobiliariafinal.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Pago implements Serializable {
    private int id;
    private int nroPago;
    private String fecha;
    private double importe;
    private int contratoId;
    private Contrato alquiler;

    public Pago(int id, int nroPago, String fecha, double importe, int contratoId, Contrato contrato) {
        this.id = id;
        this.nroPago = nroPago;
        this.fecha = fecha;
        this.importe = importe;
        this.contratoId= contratoId;
        this.alquiler = contrato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNroPago() {
        return nroPago;
    }

    public void setNroPago(int nroPago) {
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

    public Contrato getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Contrato contrato) {
        this.alquiler = contrato;
    }

    public LocalDate obtenerFecha(String fecha) {
        String date = fecha.substring(0,10);
        LocalDate localDate = LocalDate.parse(date);
        return localDate;
    }
}
