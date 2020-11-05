package com.mika.inmobiliariafinal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mika.inmobiliariafinal.modelo.Propietario;
import com.mika.inmobiliariafinal.request.ApiClient;

public class LoginViewModel extends AndroidViewModel
{
    private Context context;
    private MutableLiveData<String> error;


    public LoginViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<String> getError() {
        if(error==null){
            error=new MutableLiveData<>();
        }
        return error;
    }

    public void autenticacion(String u, String c){
        Call<String> dato = ApiClient.getMyApiClient().obtenerToken(u,c);
        dato.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    //Toast.makeText(context, response.body(), Toast.LENGTH_LONG).show();
                    SharedPreferences sp = context.getSharedPreferences("datos", 0);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("token", "Bearer "+response.body());
                    editor.commit();
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else {
                    error.postValue("La clave o contraseña son incorrectas");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                error.postValue(t.getMessage());
            }
        });
    }
}
