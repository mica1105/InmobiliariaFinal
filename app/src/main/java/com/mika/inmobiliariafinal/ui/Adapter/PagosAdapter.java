package com.mika.inmobiliariafinal.ui.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Inmueble;
import com.mika.inmobiliariafinal.modelo.Pago;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class PagosAdapter extends RecyclerView.Adapter<PagosAdapter.MyViewHolder> {
    private ArrayList<Pago> myDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public EditText pago,fecha,importe;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pago=itemView.findViewById(R.id.etNroPago);
            fecha=itemView.findViewById(R.id.etFechaPago);
            importe= itemView.findViewById(R.id.etImportePago);
        }
    }

    public PagosAdapter(ArrayList<Pago> myDataset) {
        this.myDataset = myDataset;
    }

    @NonNull
    @Override
    public PagosAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pago,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pago pagos = myDataset.get(position);
        holder.pago.setText(myDataset.get(position).getNroPago()+"");
        holder.fecha.setText(pagos.obtenerFecha(myDataset.get(position).getFecha()));
        DecimalFormat formato1= new DecimalFormat("#.00");
        holder.importe.setText("$"+formato1.format(myDataset.get(position).getImporte()));
    }

    @Override
    public int getItemCount() {
        return myDataset.size();
    }

}
