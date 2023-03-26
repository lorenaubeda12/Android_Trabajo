package com.example.vinted_lorena.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.vinted_lorena.Entity.service.Usuario;
import com.example.vinted_lorena.R;
import com.example.vinted_lorena.loginActivity;
import com.example.vinted_lorena.view_model.UsuarioViewModel;

public class RegistroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText edtMail, edtPassword, edtNombre, edtApellidos, edtDireccion, edtPais, edtCiudad, edtTelefono;
    private Button btnregistro;
    private Button btnAtras;
    private UsuarioViewModel usuarioViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        this.initViewModel();
        this.init();

    }

    private void initViewModel() {
        //Instancio la clase
        usuarioViewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);

    }

    private void init() {
        edtNombre = findViewById(R.id.nombre_regitro_txt);
        edtApellidos = findViewById(R.id.apellidos_regitro_txt);
        edtMail = findViewById(R.id.email_regitro_txt);
        edtTelefono = findViewById(R.id.tele_regitro_txt);
        edtPassword = findViewById(R.id.contraseña_regitro_txt);
        edtDireccion = findViewById(R.id.direc_regitro_txt);
        edtCiudad = findViewById(R.id.direc_regitro_txt);
        edtPais = findViewById(R.id.pais_regitro_txt);
        btnAtras = findViewById(R.id.regitro_atras);



        btnregistro = findViewById(R.id.registrarse);
        btnregistro.setOnClickListener(v -> {
            try {
                guardarDatos();
            } catch (Exception e) {
                Toast.makeText(this, "Se ha producido un error al intentar registrarse: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
        btnAtras.setOnClickListener(v -> {
            onBackPressed();
        });


    }

    private boolean validar() {
        boolean retorno = true;
        String email;
        String contraseña;
        String nombre;
        String apellido;
        String telefono;
        String direccion;
        String pais;
        String ciudad;
        email = edtMail.getText().toString();
        contraseña = edtPassword.getText().toString();
        nombre = edtNombre.getText().toString();
        apellido = edtApellidos.getText().toString();
        telefono = edtTelefono.getText().toString();
        direccion = edtDireccion.getText().toString();
        pais = edtPais.getText().toString();
        ciudad = edtCiudad.getText().toString();

        if (email.length() == 0) {
            Toast.makeText(this, "Ingrese su email", Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (contraseña.length() == 0) {
            Toast.makeText(this, "Ingrese su contraseña", Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (nombre.length() == 0) {
            Toast.makeText(this, "Ingrese su nombre", Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (apellido.length() == 0) {
            Toast.makeText(this, "Ingrese sus apellidos", Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (telefono.length() == 0 || telefono.length() < 9) {
            Toast.makeText(this, "Ingrese un telefono valido", Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (ciudad.length() == 0) {
            Toast.makeText(this, "Ingrese su ciudad", Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (pais.length() == 0) {
            Toast.makeText(this, "Ingrese su pais", Toast.LENGTH_LONG).show();
            retorno = false;
        }

        if (direccion.length() == 0) {
            Toast.makeText(this, "Ingrese su direccion", Toast.LENGTH_LONG).show();
            retorno = false;
        }


        return retorno;
    }


    private void guardarDatos() {
        Usuario usuario;
        if (validar()) {
            usuario = new Usuario();
            usuario.setNombre(edtNombre.getText().toString());
            usuario.setApellidos(edtApellidos.getText().toString());
            usuario.setEmail(edtMail.getText().toString());
            usuario.setContrasena(edtPassword.getText().toString());
            usuario.setDireccion(edtDireccion.getText().toString());
            usuario.setCiudad(edtCiudad.getText().toString());
            usuario.setPais(edtPais.getText().toString());
            usuario.setTipo_usuario("cliente");
            usuario.setTelefono(edtTelefono.getText().toString());
            usuario.setProvincia(edtCiudad.getText().toString());
            usuario.setId(0);


            try {
                this.usuarioViewModel.registro(usuario).observe(this, cResponse -> {
                    if (cResponse.getRpta() == 0) {
                        Toast.makeText(this, cResponse.getMessage() + ", ahora procederemos a registrar sus credenciales.", Toast.LENGTH_SHORT).show();
                        int idc = cResponse.getBody().getId();//Obtener el id del cliente.

                        this.usuarioViewModel.registro(usuario).observe(this, uResponse -> {
                            //Toast.makeText(this, uResponse.getMessage(), Toast.LENGTH_SHORT).show();
                            if (uResponse.getRpta() == 1) {
                                Toast.makeText(this, "Sus Datos y credenciales fueron creados correctamente: " + cResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                this.finish();
                            } else {
                                Toast.makeText(this, cResponse.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        Toast.makeText(this, "Registro correcto", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), loginActivity.class);
                        startActivity(intent);
                    }
                });

            } catch (Exception e) {
                Toast.makeText(this, "Se ha producido un error : " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Rellene todos los campos del formulario ", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}



