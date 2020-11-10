package com.mika.inmobiliariafinal.ui.contratos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Contrato;
import com.mika.inmobiliariafinal.modelo.Inquilino;
import com.mika.inmobiliariafinal.ui.Adapter.CabeceraAdapter;
import com.mika.inmobiliariafinal.ui.Adapter.ContratosAdapter;
import com.mika.inmobiliariafinal.ui.inquilinos.InquilinosViewModel;

import java.util.ArrayList;

public class TodosContratosFragment extends Fragment {

    private TodosContratosViewModel vm;
    private EditText buscar;
    private RecyclerView recyclerView;
    private ContratosAdapter contratosAdapter;

    public static TodosContratosFragment newInstance() {
        return new TodosContratosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_contratos_todos, container, false);
        inicializar(root);
        return root;
    }

    public void inicializar(View v){
        buscar= v.findViewById(R.id.etBuscar);
        recyclerView= v.findViewById(R.id.rvContratos);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(TodosContratosViewModel.class);
        vm.getContratos().observe(getViewLifecycleOwner(), new Observer<ArrayList<Contrato>>() {
            @Override
            public void onChanged(ArrayList<Contrato> contratoes) {
                Context context= getContext();
                contratosAdapter= new ContratosAdapter(contratoes,context);
                contratosAdapter.filtrar(contratoes);
                recyclerView.setAdapter(contratosAdapter);
            }
        });
        vm.recuperarContratos();
        buscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                vm.filtrar(editable.toString());
            }
        });
    }

}