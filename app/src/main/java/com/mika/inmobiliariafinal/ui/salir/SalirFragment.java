package com.mika.inmobiliariafinal.ui.salir;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
        mostrarDialogo(root);
        return root;
    }

    public void mostrarDialogo(View v){
        new AlertDialog.Builder(getContext())
                .setTitle("Salida")
                .setMessage("¿Esta seguro que desea \n cerrar sesión?")
                .setPositiveButton("Salir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                    }
                })
                .setNegativeButton("Volver", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.nav_perfil);
                    }
                })
                .show();

    }
}