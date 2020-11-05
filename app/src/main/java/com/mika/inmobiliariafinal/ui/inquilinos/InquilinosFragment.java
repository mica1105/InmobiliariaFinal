package com.mika.inmobiliariafinal.ui.inquilinos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Inquilino;
import com.mika.inmobiliariafinal.ui.Adapter.CabeceraAdapter;

import java.util.ArrayList;

public class InquilinosFragment extends Fragment {

    private InquilinosViewModel vm;
    private RecyclerView recyclerView;
    private CabeceraAdapter cabeceraAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_inquilinos, container, false);
        inicializar(root);
        return root;
    }

    public void inicializar(View v){
        recyclerView= v.findViewById(R.id.rvInquilinos);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinosViewModel.class);
        vm.getInquilinos().observe(getViewLifecycleOwner(), new Observer<ArrayList<Inquilino>>() {
            @Override
            public void onChanged(final ArrayList<Inquilino> inquilinos) {
                Context context= getContext();
                cabeceraAdapter= new CabeceraAdapter(inquilinos, context);
                recyclerView.setAdapter(cabeceraAdapter);
            }
        });
        vm.recuperarInquilinos();
    }
}