package com.mika.inmobiliariafinal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

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
        String usuario="mika@gmail.com";
        String password="mika";
        if (usuario.equals(u)  && password.equals(c)){
         Intent intent= new Intent(context, MainActivity.class);
         context.startActivity(intent);
        }else{
            error.setValue("La clave o contraseña son incorrectas");
        }
    }
}
