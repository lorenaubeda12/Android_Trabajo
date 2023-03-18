package com.example.vinted_lorena.api;

import com.example.vinted_lorena.Entity.GenericResponse;
import com.example.vinted_lorena.Entity.service.Usuario;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface UsuarioApi {
    //Ruta del controller del usuario
    String baseUrl = "api/usuario";

    //Llamada al servicio
    //Ruta del método de login
    @POST(baseUrl + "/login")
    Call<GenericResponse<Usuario>> login(@Field("email") String email, @Field("pass") String password);
}
