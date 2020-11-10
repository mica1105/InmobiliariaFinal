package com.mika.inmobiliariafinal.ui.inquilinos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mika.inmobiliariafinal.modelo.Inmueble;
import com.mika.inmobiliariafinal.modelo.Inquilino;
import com.mika.inmobiliariafinal.request.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InquilinosViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Inquilino>> inquilinos;
    private Context context;

    ArrayList<Inquilino> listaInquilinos;

    public InquilinosViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<ArrayList<Inquilino>> getInquilinos() {
        if (inquilinos==null){
            inquilinos=new MutableLiveData<>();
        }
        return inquilinos;
    }

    public void recuperarInquilinos(){
        SharedPreferences sp = context.getSharedPreferences("datos", 0);
        final String token= sp.getString("token","-1");
        final Call<ArrayList<Inquilino>> lista= ApiClient.getMyApiClient().obtenerInquilinos(token);
        lista.enqueue(new Callback<ArrayList<Inquilino>>() {
            @Override
            public void onResponse(Call<ArrayList<Inquilino>> call, Response<ArrayList<Inquilino>> response) {
                if (response.isSuccessful()){
                    listaInquilinos= new ArrayList<>();
                    listaInquilinos= response.body();
                    inquilinos.postValue(response.body());
                }
                else {
                    Toast.makeText(context,"No se recuperaron inquilinos",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Inquilino>> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void filtrar(String texto) {
        ArrayList<Inquilino> filtrarLista = new ArrayList<>();

        for(Inquilino usuario : listaInquilinos) {
            if(usuario.getNombre().toLowerCase().contains(texto.toLowerCase())) {
                filtrarLista.add(usuario);
            }
        }
        inquilinos.setValue(filtrarLista);
    }
}