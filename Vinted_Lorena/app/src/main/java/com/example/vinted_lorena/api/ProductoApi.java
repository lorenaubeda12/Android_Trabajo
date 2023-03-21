package com.example.vinted_lorena.api;

import com.example.vinted_lorena.Entity.GenericResponse;
import com.example.vinted_lorena.Entity.service.Producto;
import com.example.vinted_lorena.databinding.ListadoBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductoApi {
    //Ruta del controller del usuario
    String baseUrl = "api/producto";

    @GET(baseUrl+"/todos")
    Call<GenericResponse<List<Producto>>> listarProductos();


    @GET(baseUrl + "/{idUsuario}")
    Call<GenericResponse<List<Producto>>> listarMisProductos(@Path("idUsuario") int idUsuario);

    @GET(baseUrl+"/{idCategoria}")
    Call<GenericResponse<List<Producto>>> listarProductosCategoria(@Path("idCategoria") int idCategoria);

}
