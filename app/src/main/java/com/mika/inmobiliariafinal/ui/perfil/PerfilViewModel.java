package com.mika.inmobiliariafinal.ui.perfil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mika.inmobiliariafinal.modelo.Propietario;

public class PerfilViewModel extends ViewModel {

    private MutableLiveData<Propietario> propietario;



    public LiveData<Propietario> getPropietario() {
        if (propietario== null){
            propietario= new MutableLiveData<>();
        }
        return propietario;
    }

    public void recuperarPropietario(){
        Propietario p= new Propietario(5,"34921602","Dure","Micaela","2664540633","mika@gmail.com","mika");
        propietario.setValue(p);
    }
}