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

    public void cargarContrato(Bundle bundle){
        Contrato contrato= (Contrato)bundle.getSerializable("contrato");
        this.contrato.setValue(contrato);
    }
}