package com.mika.inmobiliariafinal.ui.pagos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mika.inmobiliariafinal.modelo.Contrato;
import com.mika.inmobiliariafinal.modelo.Pago;

import java.util.ArrayList;

public class PagosViewModel extends ViewModel {
private MutableLiveData<ArrayList<Pago>> pagos;

    public LiveData<ArrayList<Pago>> getPagos() {
        if (pagos==null){
            pagos=new MutableLiveData<>();
        }
        return pagos;
    }

    public void recuperarPagos(Bundle bundle){
        Contrato contrato= (Contrato)bundle.getSerializable("contrato");
        ArrayList<Pago> pagos1= new ArrayList<>();
        pagos1.add(new Pago(1,1,"20/08/2020",contrato.getPrecio(),contrato));
        pagos1.add(new Pago(1,2,"21/9/2020",contrato.getPrecio(),contrato));
        pagos.setValue(pagos1);
    }
}