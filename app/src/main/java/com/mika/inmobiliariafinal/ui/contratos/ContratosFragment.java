package com.mika.inmobiliariafinal.ui.contratos;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Contrato;
import com.mika.inmobiliariafinal.modelo.Propiedad;
import com.mika.inmobiliariafinal.ui.perfil.PerfilViewModel;
import com.mika.inmobiliariafinal.ui.propiedades.InmuebleFragment;
import com.mika.inmobiliariafinal.ui.propiedades.PropiedadesFragment;
import com.mika.inmobiliariafinal.ui.propiedades.PropiedadesViewModel;

import java.util.ArrayList;
import java.util.List;

public class ContratosFragment extends Fragment {

    private ContratosViewModel vm;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AppBarLayout appBar;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_contratos, container, false);
        inicializar(root);
        return root;
    }

    public void inicializar(View v){
        viewPager= v.findViewById(R.id.vpContratos);
        appBar=v.findViewById(R.id.appBarContratos);
        tabLayout= new TabLayout(getContext());
        appBar.addView(tabLayout);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratosViewModel.class);
        final ContratosFragment.ViewPageAdapter adapter = new ContratosFragment.ViewPageAdapter(getParentFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        if(getArguments() != null){
            vm.getAlquiler().observe(getViewLifecycleOwner(), new Observer<Contrato>() {
                @Override
                public void onChanged(Contrato contrato) {
                    String titulo = contrato.getId() + "";
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("contrato", contrato);
                    ContratoFragment fragment = new ContratoFragment();
                    fragment.setArguments(bundle);
                    adapter.addFragment(fragment, "Contrato" + titulo);
                    viewPager.setAdapter(adapter);
                    tabLayout.setupWithViewPager(viewPager);
                }
            });
            vm.recuperarContrato(getArguments());
        }else {
            vm.getContratos().observe(getViewLifecycleOwner(), new Observer<ArrayList<Contrato>>() {
                @Override
                public void onChanged(ArrayList<Contrato> contratos) {
                    for (Contrato contrato : contratos) {
                        String titulo = contrato.getId() + "";
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("contrato", contrato);
                        ContratoFragment fragment = new ContratoFragment();
                        fragment.setArguments(bundle);
                        adapter.addFragment(fragment, "Contrato" + titulo);
                    }
                    viewPager.setAdapter(adapter);
                    tabLayout.setupWithViewPager(viewPager);
                }
            });
            vm.recuperarContratos();
        }
    }

    public class ViewPageAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList= new ArrayList<>();
        private List<String> titulosFragment= new ArrayList<>();

        public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titulosFragment.get(position);
        }

        public void addFragment(Fragment fragment, String titulo){
            fragmentList.add(fragment);
            titulosFragment.add(titulo);
        }
    }
}