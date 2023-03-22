package com.example.vinted_lorena.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.vinted_lorena.Entity.GenericResponse;
import com.example.vinted_lorena.Entity.service.Categoria;
import com.example.vinted_lorena.api.ConfigApi;
import com.example.vinted_lorena.api.CategoriaApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Categoria_Repository {
    private final CategoriaApi valoracionApi;
    private static Categoria_Repository valoracion_repository;

    public Categoria_Repository() {
        this.valoracionApi = ConfigApi.getCategoriaApi();
    }

    public static Categoria_Repository getInstance() {
        if (valoracion_repository == null) {
            valoracion_repository = new Categoria_Repository();
        }
        return valoracion_repository;
    }

    public LiveData<GenericResponse<List<Categoria>>> listarProductosConMasValoraciones() {
        final MutableLiveData<GenericResponse<List<Categoria>>> mutableLiveData = new MutableLiveData<>();
        this.valoracionApi.listarCategorias().enqueue(new Callback<GenericResponse<List<Categoria>>>() {
            @Override
            public void onResponse(Call<GenericResponse<List<Categoria>>> call, Response<GenericResponse<List<Categoria>>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<GenericResponse<List<Categoria>>> call, Throwable t) {
                System.out.println("Error al obtener los datos" + t.getMessage());
                t.printStackTrace();
            }
        });
        return mutableLiveData;
    }


}
