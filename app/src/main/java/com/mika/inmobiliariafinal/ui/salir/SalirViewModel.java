package com.mika.inmobiliariafinal.ui.salir;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SalirViewModel extends ViewModel {
    private MutableLiveData<String> mensaje;

    public LiveData<String> getMensaje() {
        if (mensaje==null){
            mensaje=new MutableLiveData<>();
        }
        return mensaje;
    }

    public void mostrarMensaje(){
        String mensaje= "¿Esta seguro que desea \n cerrar sesión?";
        this.mensaje.setValue(mensaje);
    }
}