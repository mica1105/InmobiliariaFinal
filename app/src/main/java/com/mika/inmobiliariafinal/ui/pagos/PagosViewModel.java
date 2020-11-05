package com.mika.inmobiliariafinal.ui.pagos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Inmueble;
import com.mika.inmobiliariafinal.modelo.Pago;
import com.mika.inmobiliariafinal.request.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PagosViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private Context context;

    public PagosViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if(inmuebles == null){
            inmuebles= new MutableLiveData<>();
        }
        return inmuebles;
    }

    public void recuperarPropiedades(){
        SharedPreferences sp = context.getSharedPreferences("datos", 0);
        String token= sp.getString("token","-1");
        Call<ArrayList<Inmueble>> lista= ApiClient.getMyApiClient().obtenerPropiedades(token);
        lista.enqueue(new Callback<ArrayList<Inmueble>>() {
            @Override
            public void onResponse(Call<ArrayList<Inmueble>> call, Response<ArrayList<Inmueble>> response) {
                if(response.isSuccessful()){
                    inmuebles.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Inmueble>> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}