package com.mika.inmobiliariafinal.ui.contratos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mika.inmobiliariafinal.modelo.Contrato;
import com.mika.inmobiliariafinal.modelo.Inmueble;
import com.mika.inmobiliariafinal.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContratoViewModel extends AndroidViewModel {
private MutableLiveData<Contrato>contrato;
private MutableLiveData<String> domicilio;
private Context context;

    public ContratoViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }


    public LiveData<Contrato> getContrato() {
        if (contrato==null){
            contrato=new MutableLiveData<>();
        }
        return contrato;
    }

    public LiveData<String> getDomicilio() {
        if(domicilio== null){
            domicilio= new MutableLiveData<>();
        }
        return domicilio;
    }

    public void cargarContrato(Bundle bundle){
        Contrato contrato= (Contrato)bundle.getSerializable("contrato");
        SharedPreferences sp = context.getSharedPreferences("datos", 0);
        String token= sp.getString("token","-1");
        String id= contrato.getId()+"";
        Call<Inmueble> dato= ApiClient.getMyApiClient().buscarInmueble(token, id);
        dato.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if (response.isSuccessful()){
                    domicilio.postValue(response.body().getDireccion());
                }else {
                    domicilio.postValue("No se recupero");
                }
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        this.contrato.setValue(contrato);
    }
}