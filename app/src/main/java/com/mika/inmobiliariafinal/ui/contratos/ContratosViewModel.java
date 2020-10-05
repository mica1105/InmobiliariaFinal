package com.mika.inmobiliariafinal.ui.contratos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Contrato;
import com.mika.inmobiliariafinal.modelo.Propiedad;
import com.mika.inmobiliariafinal.modelo.Propietario;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ContratosViewModel extends ViewModel {
private MutableLiveData<ArrayList<Contrato>> contratos;

    public LiveData<ArrayList<Contrato>> getContratos() {
    if (contratos==null){
        contratos= new MutableLiveData<>();
    }
        return contratos;
    }
    public void recuperarContratos(){
        ArrayList<Contrato> alquileres= new ArrayList<>();
        alquileres.add(new Contrato(1,"29/9/2020","30/9/2021",15000,5,"España 742"));
        alquileres.add(new Contrato(2,"06/08/2020","09/08/2021",18000,5,"Av. Centenario 429"));
        alquileres.add(new Contrato(3,"16/05/2020","18/05/2021",13000,5,"Av.Illia 746"));
        contratos.setValue(alquileres);
    }
}