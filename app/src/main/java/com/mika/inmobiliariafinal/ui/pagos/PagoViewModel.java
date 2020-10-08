package com.mika.inmobiliariafinal.ui.pagos;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Contrato;
import com.mika.inmobiliariafinal.modelo.Pago;
import com.mika.inmobiliariafinal.modelo.Propiedad;

import java.util.ArrayList;

public class PagoViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Pago>> pagos;

    public LiveData<ArrayList<Pago>> getPagos() {
        if (pagos==null){
            pagos=new MutableLiveData<>();
        }
        return pagos;
    }

    public void recuperarPagos(Bundle bundle){
        Propiedad propiedad= (Propiedad) bundle.getSerializable("inmueble");
        Propiedad propiedad1=new Propiedad(1, R.drawable.casa1,"España 742", 3, "Casa","Domestico",15000,false);
        Propiedad propiedad2=new Propiedad(2,R.drawable.casa2,"Av. Centenario 429", 4, "Casa","Domestico",18000,false);
        Propiedad propiedad3=new Propiedad(3,R.drawable.dpto1,"Av.Illia 746", 3, "Departamento","Domestico",13000,false);
        Contrato contrato1= new Contrato(1,"29/09/2020","30/09/2021",15000,5,propiedad1);
        Contrato contrato2=new Contrato(2,"06/08/2020","09/08/2021",18000,5,propiedad2);
        Contrato contrato3=new Contrato(3,"16/05/2020","18/05/2021",13000,5,propiedad3);
        ArrayList<Pago> pagos1= new ArrayList<>();
        pagos1.add(new Pago(1,1,"20/09/2020",contrato1.getPrecio(),contrato1));
        pagos1.add(new Pago(2,1,"10/08/2020",contrato2.getPrecio(),contrato2));
        pagos1.add(new Pago(2,2,"15/09/2020",contrato2.getPrecio(),contrato2));
        pagos1.add(new Pago(3,1,"16/05/2020",contrato3.getPrecio(),contrato3));
        pagos1.add(new Pago(3,2,"20/06/2020",contrato3.getPrecio(),contrato3));
        pagos1.add(new Pago(3,3,"10/07/2020",contrato3.getPrecio(),contrato3));
        pagos1.add(new Pago(3,4,"15/08/2020",contrato3.getPrecio(),contrato3));
        pagos1.add(new Pago(3,5,"16/09/2020",contrato3.getPrecio(),contrato3));
        ArrayList<Pago> pagos2= new ArrayList<>();
        for (Pago pago:pagos1){
            if (pago.getContrato().getInmueble().getId()==propiedad.getId()){
                pagos2.add(pago);
            }
        }
        pagos.setValue(pagos2);
    }
}