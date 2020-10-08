package com.mika.inmobiliariafinal.ui.pagos;

import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Pago;
import com.mika.inmobiliariafinal.ui.Adapter.PagosAdapter;

import java.util.ArrayList;

public class PagoFragment extends Fragment {

    private PagoViewModel vm;
    private RecyclerView recyclerView;
    private PagosAdapter pagosAdapter;
    private TextView direccion;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_pago, container, false);
        inicializar(root);
        OnBackPressedCallback callback= new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.nav_propiedades);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),callback);
        return root;
    }

    public void inicializar(View v){
        direccion= v.findViewById(R.id.tvDireccionPagos);
        recyclerView= v.findViewById(R.id.rvPagos);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PagoViewModel.class);
        if(getArguments() != null) {
            vm.getPagos().observe(getViewLifecycleOwner(), new Observer<ArrayList<Pago>>() {
                @Override
                public void onChanged(ArrayList<Pago> pagos) {
                    for (Pago pago:pagos){
                        direccion.setText(pago.getContrato().getInmueble().getDomicilio());
                    }
                    pagosAdapter = new PagosAdapter(pagos);
                    recyclerView.setAdapter(pagosAdapter);
                }
            });
            vm.recuperarPagos(getArguments());
        }
        else {
            direccion.setText("Seleccione un Inmueble");
        }
    }

}