package com.mika.inmobiliariafinal.ui.Adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Inmueble;

import java.util.ArrayList;

public class InmueblesAdapter extends RecyclerView.Adapter<InmueblesAdapter.MyViewHolder> {
    private ArrayList<Inmueble> myDataset;
    private Context context;

    public InmueblesAdapter(ArrayList<Inmueble> myDataset, Context context) {
        this.myDataset = myDataset;
        this.context= context;
    }

    @NonNull
    @Override
    public InmueblesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_inmueble,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Inmueble inmueble = myDataset.get(position);
        String url="http://192.168.43.54:45455";
        Glide.with(context)
                .load(url+myDataset.get(position).getImagen())
                .placeholder(R.drawable.ic_launcher_background)
                .fitCenter()
                .into(holder.imagen);
        holder.direccion.setText(myDataset.get(position).getDireccion());
        holder.mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle= new Bundle();
                bundle.putSerializable("inmueble",inmueble);
                Navigation.findNavController((Activity) view.getContext(),R.id.nav_host_fragment).navigate(R.id.pagoFragment,bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myDataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView direccion;
        public ImageView imagen;
        public CardView mostrar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mostrar=itemView.findViewById(R.id.cvInmuebles);
            imagen=itemView.findViewById(R.id.ivImagen);
            direccion=itemView.findViewById(R.id.tvDireccionInmueble);
        }
    }
}
