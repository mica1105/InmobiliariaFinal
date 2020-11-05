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

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Contrato;
import com.mika.inmobiliariafinal.modelo.Inmueble;
import com.mika.inmobiliariafinal.request.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContratosViewModel extends AndroidViewModel {
private MutableLiveData<ArrayList<Contrato>> contratos;
private MutableLiveData<Contrato> alquiler;
private Context context;
private Inmueble inmueble;

    public ContratosViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<ArrayList<Contrato>> getContratos() {
    if (contratos==null){
        contratos= new MutableLiveData<>();
    }
        return contratos;
    }

    public LiveData<Contrato> getAlquiler() {
        if (alquiler==null){
            alquiler=new MutableLiveData<>();
        }
        return alquiler;
    }

    public void recuperarContratos() {
        SharedPreferences sp = context.getSharedPreferences("datos", 0);
        String token= sp.getString("token","-1");
        Call<ArrayList<Contrato>> lista= ApiClient.getMyApiClient().obtenerContratosVigentes(token);
        lista.enqueue(new Callback<ArrayList<Contrato>>() {
            @Override
            public void onResponse(Call<ArrayList<Contrato>> call, Response<ArrayList<Contrato>> response) {
                if (response.isSuccessful()){
                        contratos.postValue(response.body());
                }
                else {
                    Toast.makeText(context,"No se encontraton contratos vigentes",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Contrato>> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    public void recuperarAlquiler(Bundle bundle) {
        Inmueble inmueble= (Inmueble) bundle.getSerializable("inmueble");
        SharedPreferences sp = context.getSharedPreferences("datos", 0);
        String token= sp.getString("token","-1");
        Call<ArrayList<Contrato>> lista= ApiClient.getMyApiClient().obtenerContratosVigentes(token);
        lista.enqueue(new Callback<ArrayList<Contrato>>() {
            @Override
            public void onResponse(Call<ArrayList<Contrato>> call, Response<ArrayList<Contrato>> response) {
                if (response.isSuccessful()){
                    contratos.postValue(response.body());
                }
                else {
                    Toast.makeText(context,"No se encontraton contratos vigentes",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Contrato>> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}