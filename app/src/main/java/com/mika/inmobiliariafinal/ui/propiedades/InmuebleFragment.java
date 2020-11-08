package com.mika.inmobiliariafinal.ui.propiedades;

import android.graphics.Bitmap;
import android.graphics.Path;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Inmueble;

public class InmuebleFragment extends Fragment {

    private EditText domicilio, ambientes, tipo,uso,precio;
    private ImageView foto;
    private CheckBox disponible;
    private InmuebleViewModel vm;
    private Button contratos,pagos,editar,aceptar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View root=inflater.inflate(R.layout.fragment_inmueble, container, false);
       inicializar(root);
        return root;
    }
    public void inicializar(View v){
        domicilio= v.findViewById(R.id.etDireccion);
        ambientes=v.findViewById(R.id.etAmbientes);
        tipo=v.findViewById(R.id.etTipo);
        uso=v.findViewById(R.id.etUso);
        precio=v.findViewById(R.id.etPrecio);
        foto=v.findViewById(R.id.ivFoto);
        disponible=v.findViewById(R.id.cbDisponible);
        editar=v.findViewById(R.id.btModificar);
        aceptar=v.findViewById(R.id.btComprobar);
        contratos=v.findViewById(R.id.btContratos);
        pagos=v.findViewById(R.id.btPagos);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InmuebleViewModel.class);
        vm.getDisponible().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                disponible.setChecked(aBoolean);
            }
        });
        vm.getUrl().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Glide.with(getContext())
                        .load(s)
                        .placeholder(R.drawable.ic_launcher_background)
                        .fitCenter()
                        .into(foto);
            }
        });
        vm.getInmueble().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
            @Override
            public void onChanged(final Inmueble propiedad) {
                domicilio.setText(propiedad.getDireccion());
                ambientes.setText(propiedad.getAmbientes()+"");
                tipo.setText(propiedad.getTipo());
                uso.setText(propiedad.getUso());
                precio.setText("$"+propiedad.getPrecio());
                editar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        disponible.setEnabled(true);
                        aceptar.setVisibility(View.VISIBLE);
                        editar.setVisibility(View.GONE);
                    }
                });
                aceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        vm.editarInmueble(propiedad, disponible.isChecked());
                        disponible.setEnabled(false);
                        editar.setVisibility(View.VISIBLE);
                        aceptar.setVisibility(View.GONE);
                    }
                });
                contratos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle= new Bundle();
                        bundle.putSerializable("inmueble", propiedad);
                        Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.nav_contratos,bundle);
                    }
                });
                pagos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle= new Bundle();
                        bundle.putSerializable("inmueble", propiedad);
                        Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.pagoFragment,bundle);
                    }
                });
            }
        });
        vm.cargarInmueble(getArguments());
    }

}