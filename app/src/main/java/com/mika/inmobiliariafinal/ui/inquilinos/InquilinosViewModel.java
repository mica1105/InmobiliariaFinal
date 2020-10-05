package com.mika.inmobiliariafinal.ui.inquilinos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mika.inmobiliariafinal.modelo.Inquilino;

import java.util.ArrayList;

public class InquilinosViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Inquilino>> inquilinos;

    public LiveData<ArrayList<Inquilino>> getInquilinos() {
        if (inquilinos==null){
            inquilinos=new MutableLiveData<>();
        }
        return inquilinos;
    }

    public void recuperarInquilinos(){
        ArrayList<Inquilino> inquilinos1= new ArrayList<>();
        inquilinos1.add(new Inquilino(1,"Daniel","Lucero","31956482","Domec","2664778899","dlucero@gmail.com","Alejandra Garcia","18456752","2664264158"));
        inquilinos1.add(new Inquilino(2,"Jessica","Cabreras","36852168","Aiello","2665485133","jessi@gmail.com","Jorge Cabreras","16741235","2665412384"));
        inquilinos1.add(new Inquilino(3,"Rodrigo","Garcia","28468752","Municipalidad","2665723174","rgarcia@gmail.com","Marta Garro","19645823","2664956123"));
        inquilinos.setValue(inquilinos1);
    }
}