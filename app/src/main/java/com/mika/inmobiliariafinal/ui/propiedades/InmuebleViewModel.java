package com.mika.inmobiliariafinal.ui.propiedades;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.mika.inmobiliariafinal.request.ApiClient;

import java.io.InputStream;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        String path= "http://192.168.1.141:45455";
        url.setValue(path+inmuebleRecuperado.getImagen());
        if (inmuebleRecuperado.getEstado()== 1){
            disponible.setValue(true);
        }
        else {
            disponible.setValue(false);
        }
    }

    public void editarInmueble(Inmueble inmueble, boolean estado){
        Inmueble inmueble1= inmueble;
        if(estado){
            inmueble1.setEstado(1);
        }else {
            inmueble1.setEstado(2);
        }
        SharedPreferences sp = context.getSharedPreferences("datos", 0);
        String token= sp.getString("token","-1");
        String id= inmueble1.getId()+"";
        Call<Inmueble> editado= ApiClient.getMyApiClient().editarInmueble(token,id,inmueble1);
        editado.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if(response.isSuccessful()){
                    Toast.makeText(context,"El inmueble se edito con exito",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(context,"Ocurrio un error al editar",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
