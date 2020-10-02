package com.mika.inmobiliariafinal.ui.propiedades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Propiedad;
import com.mika.inmobiliariafinal.ui.perfil.PerfilViewModel;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesFragment extends Fragment {

    private ViewPager viewPager;
    private AppBarLayout appBar;
    private TabLayout tabLayout;
    private PropiedadesViewModel vm;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_propiedades, container, false);
        inicializar(root);
        return root;
    }

    private void inicializar(View v){
        viewPager= v.findViewById(R.id.viewPager);
        appBar=v.findViewById(R.id.appBar);
        tabLayout= new TabLayout(getContext());
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PropiedadesViewModel.class);
        appBar.addView(tabLayout);
        vm.getInmuebles().observe(getViewLifecycleOwner(), new Observer<ArrayList<Propiedad>>() {
            @Override
            public void onChanged(ArrayList<Propiedad> propiedads) {
                ViewPageAdapter adapter= new ViewPageAdapter(getParentFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
                int numero = 0;
                for(Propiedad inmueble :propiedads) {
                    numero ++;
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("inmueble",inmueble);
                    InmuebleFragment fragment= new InmuebleFragment();
                    fragment.setArguments(bundle);
                    adapter.addFragment(fragment,"Inmueble"+numero);
                }
                viewPager.setAdapter(adapter);
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        vm.recuperarPropiedades();
    }

    public class ViewPageAdapter extends FragmentPagerAdapter{

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