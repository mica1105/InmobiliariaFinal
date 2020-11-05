package com.mika.inmobiliariafinal.ui.salir;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.navigation.Navigation;

import com.mika.inmobiliariafinal.R;

public class SalirViewModel extends AndroidViewModel {
    private Context context;
    public SalirViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }
    public void salir(){
        SharedPreferences sp = context.getSharedPreferences("datos", 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("token", " ");
        System.exit(0);
    }
}
