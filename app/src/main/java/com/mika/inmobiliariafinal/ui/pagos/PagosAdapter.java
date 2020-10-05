package com.mika.inmobiliariafinal.ui.pagos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Pago;

import java.util.ArrayList;


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
        holder.pago.setText(myDataset.get(position).getPago()+"");
        holder.fecha.setText(myDataset.get(position).getFecha());
        holder.importe.setText(myDataset.get(position).getImporte()+"");
    }

    @Override
    public int getItemCount() {
        return myDataset.size();
    }

}
