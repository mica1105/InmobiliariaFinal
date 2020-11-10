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
private Context context;


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


    public void recuperarContratos(Bundle bundle) {
        final Bundle bundle1= bundle;
        SharedPreferences sp = context.getSharedPreferences("datos", 0);
        String token= sp.getString("token","-1");
        Call<ArrayList<Contrato>> lista= ApiClient.getMyApiClient().obtenerContratos(token);
        lista.enqueue(new Callback<ArrayList<Contrato>>() {
            @Override
            public void onResponse(Call<ArrayList<Contrato>> call, Response<ArrayList<Contrato>> response) {
                if (response.isSuccessful()){
                    if(bundle1!= null){
                        Inmueble inmueble= (Inmueble) bundle1.getSerializable("inmueble");
                        ArrayList<Contrato> alquileres= new ArrayList<>();
                        for(Contrato contrato:response.body()){
                            if(contrato.getInmueble().getId()== inmueble.getId()){
                                alquileres.add(contrato);
                                contratos.postValue(alquileres);
                            }
                        }
                    }else {
                        contratos.postValue(response.body());
                    }
                }
                else {
                    Toast.makeText(context,"No se encontraron contratos vigentes",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Contrato>> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}