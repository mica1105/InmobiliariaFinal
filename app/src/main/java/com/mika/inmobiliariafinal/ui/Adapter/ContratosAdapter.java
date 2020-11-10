package com.mika.inmobiliariafinal.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Contrato;
import com.mika.inmobiliariafinal.modelo.Inquilino;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ContratosAdapter extends RecyclerView.Adapter<ContratosAdapter.MyViewHolder> {
    private ArrayList<Contrato> myDataset;
    private Context context;

    public ContratosAdapter(ArrayList<Contrato> myDataset, Context context) {
        this.myDataset = myDataset;
        this.context= context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contrato,parent,false);
        return new ContratosAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contrato contrato= myDataset.get(position);
        holder.direccion.setText(myDataset.get(position).getInmueble().getDireccion());
        holder.fechaInicio.setText(myDataset.get(position).obtenerFecha(contrato.getFechaInicio()));
        holder.fechaFin.setText(myDataset.get(position).obtenerFecha(contrato.getFechaFin()));
        DecimalFormat formato1= new DecimalFormat("#.00");
        holder.precio.setText("$"+formato1.format(myDataset.get(position).getPrecio()));
    }

    @Override
    public int getItemCount() {
        return myDataset.size();
    }

    public void filtrar(ArrayList<Contrato> filtroContrato){
        this.myDataset = filtroContrato;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView direccion, fechaInicio, fechaFin, precio;
        public MyViewHolder(View itemView) {
            super(itemView);
            direccion=itemView.findViewById(R.id.tvDireccion1);
            fechaInicio=itemView.findViewById(R.id.tvFechaInicio1);
            fechaFin=itemView.findViewById(R.id.tvFechaFin1);
            precio=itemView.findViewById(R.id.tvPrecio1);
        }
    }

}
