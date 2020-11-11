package com.mika.inmobiliariafinal.ui.inquilinos;

import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Inquilino;

public class InquilinoFragment extends Fragment {

    private InquilinoViewModel vm;
    private EditText nombre,dni,trabajo,telefono,email,garante,dniGarante,telefonoGarante;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_inquilino, container, false);
        inicializar(root);
        return root;
    }

    public void inicializar(View v){
        nombre=v.findViewById(R.id.etNombreInquilino);
        dni=v.findViewById(R.id.etDniInquilino);
        trabajo=v.findViewById(R.id.etTrabajo);
        telefono=v.findViewById(R.id.etTelefonoInquilino);
        email=v.findViewById(R.id.etEmailInquilino);
        garante=v.findViewById(R.id.etNombreGarante);
        dniGarante=v.findViewById(R.id.etDniGarante);
        telefonoGarante=v.findViewById(R.id.etTelefonoGarante);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinoViewModel.class);
        vm.getInquilino().observe(getViewLifecycleOwner(), new Observer<Inquilino>() {
            @Override
            public void onChanged(Inquilino inquilino) {
               nombre.setText(inquilino.getNombre());
               dni.setText(inquilino.getDni());
               trabajo.setText(inquilino.getLugarTrabajo());
               telefono.setText(inquilino.getTelefono());
               email.setText(inquilino.getEmail());
               garante.setText(inquilino.getNombreGarante());
               dniGarante.setText(inquilino.getDniGarante());
               telefonoGarante.setText(inquilino.getTelefonoGarante());
            }
        });

        vm.cargarInquilino(getArguments());
    }


}