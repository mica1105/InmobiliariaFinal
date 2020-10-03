package com.mika.inmobiliariafinal.ui.salir;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
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

import com.mika.inmobiliariafinal.Login;
import com.mika.inmobiliariafinal.R;

public class SalirFragment extends Fragment {

    private SalirViewModel vm;
    private TextView mensaje;
    private Button salir,volver;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_salir, container, false);
        inicializar(root);
        return root;
    }

    public void inicializar(View v) {
        mensaje=v.findViewById(R.id.tvSalir);
        salir=v.findViewById(R.id.btSalir);
        volver=v.findViewById(R.id.btVolver);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(SalirViewModel.class);
        vm.getMensaje().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mensaje.setText(s);
            }
        });
        vm.mostrarMensaje();
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), Login.class);
                startActivity(intent);
            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.nav_perfil);
            }
        });
    }
}