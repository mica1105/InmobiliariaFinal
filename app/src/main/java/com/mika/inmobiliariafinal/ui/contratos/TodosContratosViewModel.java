package com.mika.inmobiliariafinal.ui.contratos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mika.inmobiliariafinal.modelo.Contrato;
import com.mika.inmobiliariafinal.request.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodosContratosViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Contrato>> contratos;
    private Context context;

    ArrayList<Contrato> listaContratos;

    public TodosContratosViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }


    public LiveData<ArrayList<Contrato>> getContratos() {
        if (contratos==null){
            contratos=new MutableLiveData<>();
        }
        return contratos;
    }

    public void recuperarContratos(){
        SharedPreferences sp = context.getSharedPreferences("datos", 0);
        final String token= sp.getString("token","-1");
        final Call<ArrayList<Contrato>> lista= ApiClient.getMyApiClient().obtenerContratos(token);
        lista.enqueue(new Callback<ArrayList<Contrato>>() {
            @Override
            public void onResponse(Call<ArrayList<Contrato>> call, Response<ArrayList<Contrato>> response) {
                if (response.isSuccessful()){
                    listaContratos= new ArrayList<>();
                    listaContratos= response.body();
                    contratos.postValue(response.body());
                }else {
                    Toast.makeText(context,"No se recuperaron contratos",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Contrato>> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void filtrar(String texto) {
        ArrayList<Contrato> filtrarLista = new ArrayList<>();

        for(Contrato contrato : listaContratos) {
            if(contrato.getInmueble().getDireccion().toLowerCase().contains(texto.toLowerCase())||contrato.obtenerFecha(contrato.getFechaInicio()).toLowerCase().contains(texto.toLowerCase()) || contrato.obtenerFecha(contrato.getFechaFin()).toLowerCase().contains(texto.toLowerCase())) {
                filtrarLista.add(contrato);
            }
        }
        contratos.setValue(filtrarLista);
    }
}