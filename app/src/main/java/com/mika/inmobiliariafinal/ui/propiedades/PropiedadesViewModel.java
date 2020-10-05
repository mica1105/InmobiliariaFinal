package com.mika.inmobiliariafinal.ui.propiedades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Propiedad;
import com.mika.inmobiliariafinal.modelo.Propietario;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Propiedad>> inmuebles;

    public LiveData<ArrayList<Propiedad>> getInmuebles() {
        if(inmuebles == null){
            inmuebles= new MutableLiveData<>();
        }
        return inmuebles;
    }

    public void recuperarPropiedades(){
        ArrayList<Propiedad> propiedades= new ArrayList<>();
        propiedades.add(new Propiedad(1,R.drawable.casa1,"España 742", 3, "Casa","Domestico",15000,false));
        propiedades.add(new Propiedad(2,R.drawable.casa2,"Av. Centenario 429", 4, "Casa","Domestico",18000,false));
        propiedades.add(new Propiedad(3,R.drawable.dto1,"Av.Illia 746", 3, "Departamento","Domestico",13000,false));
        propiedades.add(new Propiedad(4,R.drawable.local1,"Junin 461", 2, "Local","Comercial",15000,true));

        inmuebles.setValue(propiedades);
    }
}