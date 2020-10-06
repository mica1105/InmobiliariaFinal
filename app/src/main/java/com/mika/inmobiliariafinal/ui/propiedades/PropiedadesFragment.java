package com.mika.inmobiliariafinal.ui.propiedades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Propiedad;
import com.mika.inmobiliariafinal.ui.Adapter.ViewPageAdapter;
import com.mika.inmobiliariafinal.ui.Adapter.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesFragment extends Fragment {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private PropiedadesViewModel vm;
    private ViewPageAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_propiedades, container, false);
        inicializar(root);
        return root;
    }

    private void inicializar(View v){
        viewPager= v.findViewById(R.id.viewPager);
        tabLayout= v.findViewById(R.id.tlPropiedades);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PropiedadesViewModel.class);
        vm.getInmuebles().observe(getViewLifecycleOwner(), new Observer<ArrayList<Propiedad>>() {
            @Override
            public void onChanged(ArrayList<Propiedad> propiedads) {
                adapter= new ViewPageAdapter(getParentFragmentManager(),getLifecycle());
                for(final Propiedad inmueble :propiedads) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("inmueble",inmueble);
                    InmuebleFragment fragment= new InmuebleFragment();
                    fragment.setArguments(bundle);
                    adapter.addFragment(fragment);
                }
                viewPager.setAdapter(adapter);
                viewPager.setPageTransformer(new ZoomOutPageTransformer());
                new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText("Inmueble "+(position+1));
                    }
                }).attach();
            }
        });
        vm.recuperarPropiedades();
    }
}