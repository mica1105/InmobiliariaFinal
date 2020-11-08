package com.mika.inmobiliariafinal.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mika.inmobiliariafinal.modelo.Propietario;
import com.mika.inmobiliariafinal.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends AndroidViewModel {

    private MutableLiveData<Propietario> propietario;
    private Context context;

    public PerfilViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }


    public LiveData<Propietario> getPropietario() {
        if (propietario== null){
            propietario= new MutableLiveData<>();
        }
        return propietario;
    }

    public void recuperarPropietario(){
        SharedPreferences sp = context.getSharedPreferences("datos", 0);
        String token= sp.getString("token","-1");
        Call<Propietario> usuario = ApiClient.getMyApiClient().obtenerPropietario(token);
        usuario.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if(response.isSuccessful()){
                    propietario.postValue(response.body());
                }
                if (response == null){
                    Toast.makeText(context,"usuario nulo",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

   public void editarPropietario(String n, String a, String dni, String tel, String email, String password){
        SharedPreferences sp = context.getSharedPreferences("datos", 0);
        String token= sp.getString("token","-1");
        Propietario propietario1= new Propietario( dni,a,n, tel, email,password);
        Call<Propietario> usuario= ApiClient.getMyApiClient().editarPropietario(token, propietario1);
        usuario.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if(response.isSuccessful()){
                    propietario.postValue(response.body());
                    Toast.makeText(context,"Usuario modificado con exito",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(context,"No se pudo editar el usuario",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}