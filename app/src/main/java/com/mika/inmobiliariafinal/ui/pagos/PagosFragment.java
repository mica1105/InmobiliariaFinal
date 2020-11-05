package com.mika.inmobiliariafinal.ui.pagos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Inmueble;
import com.mika.inmobiliariafinal.ui.Adapter.InmueblesAdapter;

import java.util.ArrayList;

public class PagosFragment extends Fragment {

    private PagosViewModel vm;
    private RecyclerView recyclerView;
    private InmueblesAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_pagos, container, false);
        inicializar(root);
        return root;
    }

    public void inicializar(View v){
        recyclerView= v.findViewById(R.id.rvInmuebles);
        GridLayoutManager manager= new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PagosViewModel.class);
        vm.getInmuebles().observe(getViewLifecycleOwner(), new Observer<ArrayList<Inmueble>>() {
            @Override
            public void onChanged(ArrayList<Inmueble> propiedads) {
                Context context= getContext();
                adapter= new InmueblesAdapter(propiedads, context);
                recyclerView.setAdapter(adapter);
            }
        });
        vm.recuperarPropiedades();


    }
}