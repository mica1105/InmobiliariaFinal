package com.mika.inmobiliariafinal.request;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mika.inmobiliariafinal.modelo.Contrato;
import com.mika.inmobiliariafinal.modelo.Inmueble;
import com.mika.inmobiliariafinal.modelo.Inquilino;
import com.mika.inmobiliariafinal.modelo.Pago;
import com.mika.inmobiliariafinal.modelo.Propietario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class ApiClient {

    private static final String PATH= "http://192.168.1.111:45455/api/";
    private static MyApiInterface myApiInterface;

    public static MyApiInterface getMyApiClient(){
        Gson gson= new GsonBuilder().setLenient().create();
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        myApiInterface= retrofit.create(MyApiInterface.class);
        return myApiInterface;
    }

    public interface MyApiInterface {

        @FormUrlEncoded
        @POST("Propietario/login")
        Call<String> obtenerToken(@Field("Usuario") String usuario, @Field("Clave") String clave);

        @GET("Propietario")
        Call<Propietario> obtenerPropietario(@Header("Authorization") String authorization);

        @PUT("Propietario")
        Call<Propietario> editarPropietario(@Header("Authorization") String authorization, @Body Propietario usuario);

        @GET("Inmueble/")
        Call<ArrayList<Inmueble>> obtenerPropiedades(@Header("Authorization") String authorization);

        @GET("Inmueble/{id}")
        Call<Inmueble> obtenerInmueble(@Header("Authorization") String authorization, @Path("id") String id);

        @GET("Inmueble/PorContrato/{id}")
        Call<Inmueble> buscarInmueble(@Header("Authorization") String authorization, @Path("id") String id);

        @GET("Inmueble/PorInquilino/{id}")
        Call<Inmueble> inmueblePorInquilino(@Header("Authorization") String authorization, @Path("id") String id);

        @GET("Inquilino/PorPropietario")
        Call<ArrayList<Inquilino>> obtenerInquilinos(@Header("Authorization") String authorization);

        @GET("Contrato")
        Call<ArrayList<Contrato>> obtenerContratosVigentes(@Header("Authorization") String authorization);

        @GET("Contrato/{id}")
        Call<Contrato> obtenerContrato(@Header("Authorization") String authorization, @Path("id") String id);

        @GET("Pago/PorContrato/{id}")
        Call<ArrayList<Pago>> obtenerPagos(@Header("Authorization") String authorization, @Path("id") String id);

    }
}
