package com.example.vinted_lorena.view_model;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.vinted_lorena.Entity.GenericResponse;
import com.example.vinted_lorena.Entity.service.Valoracion;
import com.example.vinted_lorena.Repository.Categoria_Repository;

import java.util.List;

public class CategoriaViewModel extends AndroidViewModel {
    private final Categoria_Repository valoracion_repository;

    public CategoriaViewModel() {
        super();
        this.valoracion_repository = Categoria_Repository.getInstance();
    }

    public LiveData<GenericResponse<List<Valoracion>>> listarCategorias() {
        return this.listarCategorias();
    }
}
