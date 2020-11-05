package com.mika.inmobiliariafinal.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Propietario;

public class PerfilFragment extends Fragment {

    private PerfilViewModel vm;
    private EditText etDni, etApellido, etNombre,etTelefono, etEmail, etPassword;
    private Button btAceptar, btEditar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
        inicializar(root);
        return root;
    }

    private void inicializar(View v){
        etDni = v.findViewById(R.id.etDni);
        etApellido= v.findViewById(R.id.etApellido);
        etNombre=v.findViewById(R.id.etNombre);
        etTelefono= v.findViewById(R.id.etTelefono);
        etEmail= v.findViewById(R.id.etEmail);
        etPassword= v.findViewById(R.id.etPassword);
        btEditar= v.findViewById(R.id.btEditar);
        btAceptar= v.findViewById(R.id.btAceptar);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PerfilViewModel.class);
        vm.getPropietario().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                etDni.setText(propietario.getDni());
                etApellido.setText(propietario.getApellido());
                etNombre.setText(propietario.getNombre());
                etTelefono.setText(propietario.getTelefono());
                etEmail.setText(propietario.getEmail());
                etPassword.setText(propietario.getClave());
            }
        });
        vm.recuperarPropietario();

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etDni.setEnabled(true);
                etApellido.setEnabled(true);
                etNombre.setEnabled(true);
                etTelefono.setEnabled(true);
                btEditar.setVisibility(View.GONE);
                btAceptar.setVisibility(View.VISIBLE);
            }
        });
        btAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.editarPropietario(etNombre.getText().toString(), etApellido.getText().toString(),
                        etDni.getText().toString(),etTelefono.getText().toString(),etEmail.getText().toString(),
                        etPassword.getText().toString());
                etDni.setEnabled(false);
                etApellido.setEnabled(false);
                etNombre.setEnabled(false);
                etTelefono.setEnabled(false);
                btEditar.setVisibility(View.VISIBLE);
                btAceptar.setVisibility(View.GONE);
            }
        });
    }
}