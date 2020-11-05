package com.mika.inmobiliariafinal.ui.propiedades;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mika.inmobiliariafinal.modelo.Inmueble;

import java.io.InputStream;
import java.net.URL;

public class InmuebleViewModel extends AndroidViewModel {
    private MutableLiveData<Inmueble> inmueble;
    private MutableLiveData<Boolean> disponible;
    private MutableLiveData<String> url;
    private Context context;

    public InmuebleViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }


    public LiveData<Inmueble> getInmueble() {
        if (inmueble==null){
            inmueble=new MutableLiveData<>();
        }
        return inmueble;
    }

    public LiveData<Boolean> getDisponible() {
        if(disponible== null){
            disponible= new MutableLiveData<>();
        }
        return disponible;
    }

    public LiveData<String> getUrl() {
        if(url== null){
            url= new MutableLiveData<>();
        }
        return url;
    }

    public void cargarInmueble(Bundle bundle){
        Inmueble inmuebleRecuperado = (Inmueble) bundle.getSerializable("inmueble");
        Log.d("salida ", inmuebleRecuperado.getImagen()+" "+inmuebleRecuperado.getPropietarioId());
        inmueble.setValue(inmuebleRecuperado);
        String path= "http://192.168.1.111:45455";
        url.setValue(path+inmuebleRecuperado.getImagen());
        if (inmuebleRecuperado.getEstado()== 1){
            disponible.setValue(true);
        }
        else {
            disponible.setValue(false);
        }
    }
}
