package com.mika.inmobiliariafinal.ui.pagos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Contrato;
import com.mika.inmobiliariafinal.modelo.Pago;
import com.mika.inmobiliariafinal.modelo.Inmueble;
import com.mika.inmobiliariafinal.request.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PagoViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Pago>> pagos;
    private MutableLiveData<String> direccion;
    private Context context;

    public PagoViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<ArrayList<Pago>> getPagos() {
        if (pagos==null){
            pagos=new MutableLiveData<>();
        }
        return pagos;
    }

    public LiveData<String> getDireccion() {
        if(direccion== null){
            direccion= new MutableLiveData<>();
        }
        return direccion;
    }

    public void recuperarPagos(Bundle bundle){
        Inmueble propiedad= (Inmueble) bundle.getSerializable("inmueble");
        SharedPreferences sp = context.getSharedPreferences("datos", 0);
        String token= sp.getString("token","-1");
        String id= propiedad.getId()+"";
        Call<ArrayList<Pago>> lista= ApiClient.getMyApiClient().obtenerPagos(token, id);
        lista.enqueue(new Callback<ArrayList<Pago>>() {
            @Override
            public void onResponse(Call<ArrayList<Pago>> call, Response<ArrayList<Pago>> response) {
                if(response.isSuccessful()) {
                    pagos.setValue(response.body());
                }else {
                    Toast.makeText(context,"No se encontraron pagos",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Pago>> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        Call<Inmueble> dato= ApiClient.getMyApiClient().obtenerInmueble(token,id);
        dato.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if (response.isSuccessful()){
                    direccion.postValue(response.body().getDireccion());
                }
                else {
                    direccion.postValue("No se obtuvo");
                }
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}