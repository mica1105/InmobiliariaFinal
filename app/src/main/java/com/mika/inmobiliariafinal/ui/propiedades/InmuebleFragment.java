package com.mika.inmobiliariafinal.ui.propiedades;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Propiedad;

public class InmuebleFragment extends Fragment {

    private EditText domicilio, ambietes, tipo,uso,precio;
    private ImageView foto;
    private CheckBox disponible;
    private InmuebleViewModel vm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View root=inflater.inflate(R.layout.fragment_inmueble, container, false);
       inicializar(root);
        return root;
    }
    public void inicializar(View v){
        domicilio= v.findViewById(R.id.etDireccion);
        ambietes=v.findViewById(R.id.etAmbientes);
        tipo=v.findViewById(R.id.etTipo);
        uso=v.findViewById(R.id.etUso);
        precio=v.findViewById(R.id.etPrecio);
        foto=v.findViewById(R.id.ivFoto);
        disponible=v.findViewById(R.id.cbDisponible);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InmuebleViewModel.class);
        vm.getInmueble().observe(getViewLifecycleOwner(), new Observer<Propiedad>() {
            @Override
            public void onChanged(Propiedad propiedad) {
                domicilio.setText(propiedad.getDomicilio());
                ambietes.setText(propiedad.getAmbientes()+"");
                tipo.setText(propiedad.getTipo());
                uso.setText(propiedad.getUso());
                precio.setText("$"+propiedad.getPrecio());
                foto.setImageResource(propiedad.getFoto());
                disponible.setChecked(propiedad.isDisponible());
            }
        });
        vm.cargarInmueble(getArguments());
    }

}