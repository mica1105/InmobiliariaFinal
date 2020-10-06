package com.mika.inmobiliariafinal.ui.contratos;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Contrato;
import com.mika.inmobiliariafinal.modelo.Propiedad;
import com.mika.inmobiliariafinal.ui.Adapter.ViewPageAdapter;
import com.mika.inmobiliariafinal.ui.Adapter.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class ContratosFragment extends Fragment {

    private ContratosViewModel vm;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private ViewPageAdapter adapter;
    private TextView mensaje;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_contratos, container, false);
        inicializar(root);
        return root;
    }

    public void inicializar(View v){
        mensaje=v.findViewById(R.id.tvMensaje);
        viewPager= v.findViewById(R.id.vpContratos);
        tabLayout=v.findViewById(R.id.tlContratos);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratosViewModel.class);
        adapter= new ViewPageAdapter(getParentFragmentManager(),getLifecycle());
        if(getArguments() != null){
            vm.getMensaje().observe(getViewLifecycleOwner(), new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    if(s != ""){
                        mensaje.setText(s);
                        mensaje.setVisibility(View.VISIBLE);
                    }
                }
            });
            vm.getAlquiler().observe(getViewLifecycleOwner(), new Observer<Contrato>() {
                @Override
                public void onChanged(Contrato contrato) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("contrato", contrato);
                    ContratoFragment fragment = new ContratoFragment();
                    fragment.setArguments(bundle);
                    adapter.addFragment(fragment);
                    viewPager.setAdapter(adapter);
                    new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
                        @Override
                        public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                            tab.setText("Contrato "+(position+1));
                        }
                    }).attach();
                }
            });
            vm.recuperarContrato(getArguments());
        }else {
            vm.getContratos().observe(getViewLifecycleOwner(), new Observer<ArrayList<Contrato>>() {
                @Override
                public void onChanged(ArrayList<Contrato> contratos) {
                    for (Contrato contrato : contratos) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("contrato", contrato);
                        ContratoFragment fragment = new ContratoFragment();
                        fragment.setArguments(bundle);
                        adapter.addFragment(fragment);
                    }
                    viewPager.setAdapter(adapter);
                    viewPager.setPageTransformer(new ZoomOutPageTransformer());
                    new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
                        @Override
                        public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                            tab.setText("Contrato "+(position+1));
                        }
                    }).attach();
                }
            });
            vm.recuperarContratos();
        }
    }
}