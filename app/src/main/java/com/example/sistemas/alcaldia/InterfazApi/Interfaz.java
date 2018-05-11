package com.example.sistemas.alcaldia.InterfazApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Interfaz
{

    @GET("c3f5-m5kx.json")
    Call<ArrayList<Inventario>> obtenerListaInventario();
}
