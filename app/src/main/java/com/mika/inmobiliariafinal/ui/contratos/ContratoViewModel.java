package com.mika.inmobiliariafinal.ui.contratos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mika.inmobiliariafinal.modelo.Contrato;
import com.mika.inmobiliariafinal.modelo.Propiedad;

public class ContratoViewModel extends ViewModel {
private MutableLiveData<Contrato>contrato;


    public LiveData<Contrato> getContrato() {
        if (contrato==null){
            contrato=new MutableLiveData<>();
        }
        return contrato;
    }

    public void cargarContrato(Bundle bundle){
        Contrato contrato= (Contrato)bundle.getSerializable("contrato");

        this.contrato.setValue(contrato);
    }
}