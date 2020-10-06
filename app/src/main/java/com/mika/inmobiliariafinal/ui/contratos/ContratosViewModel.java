package com.mika.inmobiliariafinal.ui.contratos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Contrato;
import com.mika.inmobiliariafinal.modelo.Propiedad;
import com.mika.inmobiliariafinal.modelo.Propietario;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ContratosViewModel extends AndroidViewModel {
private MutableLiveData<ArrayList<Contrato>> contratos;
private MutableLiveData<Contrato> alquiler;
private Context context;

    public ContratosViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<ArrayList<Contrato>> getContratos() {
    if (contratos==null){
        contratos= new MutableLiveData<>();
    }
        return contratos;
    }

    public LiveData<Contrato> getAlquiler() {
        if (alquiler==null){
            alquiler=new MutableLiveData<>();
        }
        return alquiler;
    }

    public void recuperarContratos(){
        Propiedad propiedad1=new Propiedad(1,R.drawable.casa1,"España 742", 3, "Casa","Domestico",15000,false);
        Propiedad propiedad2=new Propiedad(2,R.drawable.casa2,"Av. Centenario 429", 4, "Casa","Domestico",18000,false);
        Propiedad propiedad3=new Propiedad(3,R.drawable.dpto1,"Av.Illia 746", 3, "Departamento","Domestico",13000,false);
        ArrayList<Contrato> alquileres= new ArrayList<>();
        alquileres.add(new Contrato(1,"29/09/2020","30/09/2021",15000,5,propiedad1));
        alquileres.add(new Contrato(2,"06/08/2020","09/08/2021",18000,5,propiedad2));
        alquileres.add(new Contrato(3,"16/05/2020","18/05/2021",13000,5,propiedad3));
        contratos.setValue(alquileres);
    }

    public void recuperarContrato(Bundle bundle){
        Propiedad inmueble= (Propiedad)bundle.getSerializable("inmueble");
        Propiedad propiedad1=new Propiedad(1,R.drawable.casa1,"España 742", 3, "Casa","Domestico",15000,false);
        Propiedad propiedad2=new Propiedad(2,R.drawable.casa2,"Av. Centenario 429", 4, "Casa","Domestico",18000,false);
        Propiedad propiedad3=new Propiedad(3,R.drawable.dpto1,"Av.Illia 746", 3, "Departamento","Domestico",13000,false);
        ArrayList<Contrato> alquileres= new ArrayList<>();
        alquileres.add(new Contrato(1,"29/09/2020","30/09/2021",15000,5,propiedad1));
        alquileres.add(new Contrato(2,"06/08/2020","09/08/2021",18000,5,propiedad2));
        alquileres.add(new Contrato(3,"16/05/2020","18/05/2021",13000,5,propiedad3));
        for (Contrato contrato:alquileres){
            if (contrato.getInmueble().getId()==inmueble.getId()) {
                alquiler.setValue(contrato);
            }
        }
    }
}