package com.mika.inmobiliariafinal.ui.propiedades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mika.inmobiliariafinal.modelo.Propiedad;
import com.mika.inmobiliariafinal.modelo.Propietario;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesViewModel extends ViewModel {

    private MutableLiveData<ArrayList> inmuebles;

    public LiveData<ArrayList> getInmuebles() {
        if(inmuebles == null){
            inmuebles= new MutableLiveData<>();
        }
        return inmuebles;
    }

    public void recuperarPropiedades(){
        ArrayList<Propiedad> propiedades= new ArrayList<>();
        Propiedad p1= new Propiedad("España 742", 3, "Casa","Domestico",15000,true);
        Propiedad p2= new Propiedad("Av. Centenario 429", 4, "Casa","Domestico",18000,true);
        Propiedad p3= new Propiedad("Av.Illia 746", 3, "Departamento","Domestico",13000,true);
        Propiedad p4= new Propiedad("Junin 461", 2, "Local","Comercial",15000,true);
        propiedades.add(p1);
        propiedades.add(p2);
        propiedades.add(p3);
        propiedades.add(p4);
        inmuebles.setValue(propiedades);
    }
}