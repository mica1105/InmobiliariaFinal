package com.mika.inmobiliariafinal.ui.propiedades;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mika.inmobiliariafinal.modelo.Propiedad;

public class InmuebleViewModel extends AndroidViewModel {
    private MutableLiveData<Propiedad> inmueble;

    public InmuebleViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<Propiedad> getInmueble() {
        if (inmueble==null){
            inmueble=new MutableLiveData<>();
        }
        return inmueble;
    }
    public void cargarInmueble(Bundle bundle){
        Propiedad inmuebleRecuperado = (Propiedad) bundle.getSerializable("inmueble");
        inmueble.setValue(inmuebleRecuperado);
    }

}
