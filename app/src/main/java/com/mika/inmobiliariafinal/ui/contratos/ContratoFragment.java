package com.mika.inmobiliariafinal.ui.contratos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Contrato;
import com.mika.inmobiliariafinal.modelo.Propiedad;

public class ContratoFragment extends Fragment {

    private ContratoViewModel vm;
    private TextView direccion, fechaInicio, fechaFin, precio;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_contrato, container, false);
        inicializar(root);
        return root;
    }

    public void inicializar(View v){
        direccion=v.findViewById(R.id.tvDireccion);
        fechaInicio=v.findViewById(R.id.tvFechaInicio);
        fechaFin=v.findViewById(R.id.tvFechaFin);
        precio=v.findViewById(R.id.tvPrecio);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratoViewModel.class);
        vm.getContrato().observe(getViewLifecycleOwner(), new Observer<Contrato>() {
            @Override
            public void onChanged(final Contrato contrato) {
                direccion.setText(contrato.getInmueble().getDomicilio());
                precio.setText("$"+contrato.getPrecio());
                fechaInicio.setText(contrato.getFechaInicio());
                fechaFin.setText(contrato.getFechaFin());
            }
        });
        vm.cargarContrato(getArguments());
    }
}