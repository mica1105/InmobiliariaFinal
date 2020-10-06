package com.mika.inmobiliariafinal.ui.inquilinos;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Inquilino;

import java.util.ArrayList;

public class CabeceraAdapter extends RecyclerView.Adapter<CabeceraAdapter.MyViewHolder>  {

    private ArrayList<Inquilino> myDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public EditText nombre, dni, telefono, email;
        public TextView domicilio;
        public CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);
            nombre= itemView.findViewById(R.id.etNombreCompleto);
            dni=itemView.findViewById(R.id.etDniInq);
            telefono=itemView.findViewById(R.id.etTelInqui);
            email=itemView.findViewById(R.id.etEmailInqui);
            domicilio=itemView.findViewById(R.id.tvDomicilio);
            cardView=itemView.findViewById(R.id.cvInquilinos);
        }
    }

    public CabeceraAdapter(ArrayList<Inquilino> myDataset) {
        this.myDataset = myDataset;
    }

    @NonNull
    @Override
    public CabeceraAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cabecera_inquilinos,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final Inquilino inquilino= myDataset.get(position);
        holder.nombre.setText(myDataset.get(position).getNombre()+" "+myDataset.get(position).getApellido());
        holder.dni.setText(myDataset.get(position).getDni());
        holder.telefono.setText(myDataset.get(position).getTelefono());
        holder.email.setText(myDataset.get(position).getEmail());
        switch (position){
            case 0: {
                holder.domicilio.setText("España 742");
                break;}
            case 1:{
                holder.domicilio.setText("Av. Centenario 429");
                break;
            }
            case 2:{
                holder.domicilio.setText("Av.Illia 746");
                break;
            }
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle= new Bundle();
                bundle.putSerializable("inquilino",inquilino);
                Navigation.findNavController((Activity) view.getContext(),R.id.nav_host_fragment).navigate(R.id.inquilinoFragment,bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myDataset.size();
    }


}
