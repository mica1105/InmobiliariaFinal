package com.mika.inmobiliariafinal.ui.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.mika.inmobiliariafinal.R;
import com.mika.inmobiliariafinal.modelo.Inmueble;
import com.mika.inmobiliariafinal.modelo.Inquilino;
import com.mika.inmobiliariafinal.request.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CabeceraAdapter extends RecyclerView.Adapter<CabeceraAdapter.MyViewHolder>  {

    private ArrayList<Inquilino> myDataset;
    private Context context;
    public static class MyViewHolder extends RecyclerView.ViewHolder {

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

    public CabeceraAdapter(ArrayList<Inquilino> myDataset, Context context) {
        this.myDataset = myDataset;
        this.context= context;
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

        SharedPreferences sp =  context.getSharedPreferences("datos", 0);
        String token= sp.getString("token","-1");
        String id= myDataset.get(position).getId()+"";
        Call<Inmueble> dato= ApiClient.getMyApiClient().inmueblePorInquilino(token,id);
        dato.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if(response.isSuccessful()){
                    holder.domicilio.setText(response.body().getDireccion());
                }else {
                    holder.domicilio.setText("No se recupero");
                }
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

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

    public void filtrar(ArrayList<Inquilino> filtroInquilino){
        this.myDataset = filtroInquilino;
        notifyDataSetChanged();
    }
}
