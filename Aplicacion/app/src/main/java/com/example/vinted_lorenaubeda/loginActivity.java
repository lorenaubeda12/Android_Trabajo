package com.example.vinted_lorenaubeda;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.vinted_lorenaubeda.Entity.service.Usuario;
import com.example.vinted_lorenaubeda.utilis.DateSerializer;
import com.example.vinted_lorenaubeda.utilis.TimeSerializer;
import com.example.vinted_lorenaubeda.view_model.UsuarioViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.sql.Date;
import java.sql.Time;

public class loginActivity extends AppCompatActivity {

    private EditText edtMail, edtPassword;
    private Button btnInicioSesion;
    private Button btnAtras;
    private UsuarioViewModel usuarioViewModel;
    private TextView email, contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        this.initViewModel();
        this.init();
    }

    private void initViewModel() {
        //Instancio la clase
        usuarioViewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);

    }

    private void init() {
        edtMail = findViewById(R.id.email_login);
        edtPassword = findViewById(R.id.contraseña_login);
        btnInicioSesion = findViewById(R.id.entrar_login);
        btnInicioSesion.setOnClickListener(v -> {
            usuarioViewModel.login(edtMail.getText().toString(), edtPassword.getText().toString()).observe(this, response -> {
                if (response.getRpta() == 1) {
                    Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
                    Usuario usuario = response.getBody();
                    //Almacen de usuario en sesion
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                    SharedPreferences.Editor editor = preferences.edit();

                    final Gson gson= new GsonBuilder()
                            .registerTypeAdapter(Date.class, new DateSerializer())
                            .registerTypeAdapter(Time.class,new TimeSerializer()).create();

                            editor.putString("usuarioJson",gson.toJson(usuario,new TypeToken<Usuario>(){}.getType()));
                            editor.apply();
                            //Limpiar campos
                            edtMail.setText("");
                            edtPassword.setText("");
                            startActivity(new Intent(this, MainActivity.class));
                } else {
                    Toast.makeText(this, "Ocurrio un error" + response.getMessage(), Toast.LENGTH_SHORT).show();
                    System.out.println("Usuario no logueado");
                }
            });
        });

    }

}

