package com.mika.inmobiliariafinal.ui.inquilinos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mika.inmobiliariafinal.modelo.Inquilino;

public class InquilinoViewModel extends ViewModel {
    private MutableLiveData<Inquilino> inquilino;

    public LiveData<Inquilino> getInquilino() {
        if (inquilino==null){
            inquilino= new MutableLiveData<>();
        }
        return inquilino;
    }

    public void cargarInquilino(Bundle bundle){
        Inquilino inquilinoRecuperado=(Inquilino)bundle.getSerializable("inquilino");
        inquilino.setValue(inquilinoRecuperado);
    }
}