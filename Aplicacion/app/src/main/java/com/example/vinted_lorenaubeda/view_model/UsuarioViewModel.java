package com.example.vinted_lorenaubeda.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.vinted_lorenaubeda.Entity.GenericResponse;
import com.example.vinted_lorenaubeda.Entity.service.Usuario;
import com.example.vinted_lorenaubeda.Repository.Usuario_Repository;

public class UsuarioViewModel extends AndroidViewModel {
    private final Usuario_Repository repository;

    public UsuarioViewModel(@NonNull Application application) {
        super(application);
        this.repository = Usuario_Repository.getInstance();

    }

    public LiveData<GenericResponse<Usuario>> login(String email, String password) {
        return this.repository.login(email, password);
    }
}
