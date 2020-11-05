package com.mika.inmobiliariafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private LoginViewModel login;
    private Button iniciar;
    private EditText usuario;
    private EditText clave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inicilizar();
        
    }
    public void inicilizar(){
        login= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginViewModel.class);
        login.getError().observe(this,new Observer<String>() {
            @Override
            public void onChanged(String error) {
                Toast.makeText(getApplicationContext(),error,Toast.LENGTH_LONG).show();
            }
        });
        iniciar= findViewById(R.id.btIniciar);
        usuario=findViewById(R.id.etCorreo);
        clave=findViewById(R.id.etContrasenia);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.autenticacion(usuario.getText().toString(),clave.getText().toString());
            }
        });
    }
}