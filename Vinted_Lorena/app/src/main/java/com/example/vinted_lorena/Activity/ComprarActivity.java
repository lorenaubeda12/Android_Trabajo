package com.example.vinted_lorena.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.LocaleData;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vinted_lorena.Entity.GenericResponse;
import com.example.vinted_lorena.Entity.service.Compra;
import com.example.vinted_lorena.Entity.service.Producto;
import com.example.vinted_lorena.Entity.service.Tipo_envio;
import com.example.vinted_lorena.Entity.service.Usuario;
import com.example.vinted_lorena.R;
import com.example.vinted_lorena.Repository.TipoEnvio_Repository;
import com.example.vinted_lorena.api.ConfigApi;
import com.example.vinted_lorena.api.TipoEnvioIApi;
import com.example.vinted_lorena.home;
import com.example.vinted_lorena.loginActivity;
import com.example.vinted_lorena.ui.home.HomeFragment;
import com.example.vinted_lorena.utilis.DateSerializer;
import com.example.vinted_lorena.utilis.TimeSerializer;
import com.example.vinted_lorena.view_model.CompraViewModel;
import com.example.vinted_lorena.view_model.UsuarioViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ComprarActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageView imgProductoDetalle;
    private Button btnFinalizarCompra;
    private TextView tvNombreProducto, tvPrecioProducto, tvDescripcionProducto, tvPrecioFinal, tvVendedor;
    private Spinner tipoEnvio;
    static Usuario usuario;
    private CompraViewModel compraViewModel;

    static String elegidoEnvio;
    static int tipoEnvioElegido;
    static double precioProducto;
    static double precioFinal;
    static Tipo_envio envioElegido;
    final Gson g = new GsonBuilder()
            .registerTypeAdapter(Date.class, new DateSerializer())
            .registerTypeAdapter(Time.class, new TimeSerializer())
            .create();

    Producto producto;

    TipoEnvio_Repository tipoEnvioRepository = TipoEnvio_Repository.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);
        init();
        loadData();


    }


    private void init() {
        Toolbar toolbar = this.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_volver_atras);
        toolbar.setNavigationOnClickListener(v -> {//Reemplazo con lamba
            this.finish();
            this.overridePendingTransition(R.anim.rigth_in, R.anim.rigth_out);
        });
        this.tipoEnvio = findViewById(R.id.tipoEnvio);
        this.tvVendedor = findViewById(R.id.vendedorProductoComprar);
        this.imgProductoDetalle = findViewById(R.id.productoComprar);
        this.btnFinalizarCompra = findViewById(R.id.btnPagar);
        this.tvNombreProducto = findViewById(R.id.nombreProductoComprar);
        this.tvPrecioProducto = findViewById(R.id.precioProductoComprar);
        this.tvDescripcionProducto = findViewById(R.id.descripcionProductoComprar);
        this.tvPrecioFinal = findViewById(R.id.PrecioFinalTotal);


    }

    public String generateUrl(String s) {
        String[] p = s.split("/");
        String link = "https://drive.google.com/uc?export=download&id=" + p[5];
        return link;
    }


    private void loadData() {
        final String productoElegido = this.getIntent().getStringExtra("producto");
        if (productoElegido != null) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
            final Gson g = new GsonBuilder()
                    .registerTypeAdapter(Date.class, new DateSerializer())
                    .registerTypeAdapter(Time.class, new TimeSerializer())
                    .create();
            String usuarioJson = sp.getString("usuarioJson", null);
            if (usuarioJson != null) {

                usuario = g.fromJson(usuarioJson, Usuario.class);
                this.producto = g.fromJson(productoElegido, Producto.class);
                this.tvNombreProducto.setText(this.producto.getNombre_producto());
                this.tvPrecioProducto.setText(String.valueOf(this.producto.getPrecio()) + "€");
                this.tvDescripcionProducto.setText(this.producto.getDescripcion());
                if (productoElegido != null) {
                    this.producto = g.fromJson(productoElegido, Producto.class);
                    this.tvNombreProducto.setText(this.producto.getNombre_producto());
                    this.tvPrecioProducto.setText(String.valueOf(this.producto.getPrecio()) + "€");
                    this.tvDescripcionProducto.setText(this.producto.getDescripcion());
                    this.tvVendedor.setText(this.producto.getId_usuario().getnombreCompleto());
                    this.tipoEnvio.setOnItemSelectedListener(this);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tiposDeEnvio, android.R.layout.simple_spinner_item);
                    this.tipoEnvio.setAdapter(adapter);

                    precioProducto = this.producto.getPrecio();
                    this.tipoEnvio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            elegidoEnvio = parent.getItemAtPosition(position).toString();
                            if (elegidoEnvio.contains("Envio Estándar")) {
                                tipoEnvioElegido = 1;
                                precioFinal = precioProducto + 5;
                                tvPrecioFinal.setText(String.valueOf(precioFinal) + "€");

                            } else if (elegidoEnvio.contains("Envio Urgente")) {
                                precioFinal = precioProducto + 10;
                                tipoEnvioElegido = 3;
                                tvPrecioFinal.setText(String.valueOf(precioFinal) + "€");

                            } else if (elegidoEnvio.contains("Envio Certificado")) {
                                precioFinal = precioProducto + 6;
                                tipoEnvioElegido = 4;
                                tvPrecioFinal.setText(String.valueOf(precioFinal) + "€");
                            } else {
                                Toast.makeText(ComprarActivity.this, "Se aplicara el envio basico que tiene un costo de 2€", Toast.LENGTH_SHORT).show();
                                precioFinal = precioProducto + 2;
                                tipoEnvioElegido = 2;
                                tvPrecioFinal.setText(String.valueOf(precioFinal) + "€");

                            }

                            /*switch (elegidoEnvio) {
                                case "Envio estándar":
                                    precioFinal+=5;
                                    tipoEnvioElegido = 1;

                                case "Envio Urgente":
                                    precioFinal+=10;
                                    tipoEnvioElegido = 3;

                                case "Envio Certificado":
                                    precioFinal+=6;
                                    tipoEnvioElegido = 4;

                            }*/

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }

                    });
                    /* this.tvPrecioFinal.setText(String.valueOf(precioFinal)+"€");*/

                    String ulrImage = generateUrl(this.producto.getImagen());
                    Picasso picasso = new Picasso.Builder(this)
                            .downloader(new OkHttp3Downloader(ConfigApi.getClient()))
                            .build();
                    picasso.load(ulrImage)
                            .error(cn.pedant.SweetAlert.R.drawable.error_center_x)
                            .into(this.imgProductoDetalle);
                } else {
                    System.out.println("Error al obtener los detalles del producto");
                }
            }

        }

        btnFinalizarCompra.setOnClickListener(v -> {
            try {
                guardarDatos();
            } catch (Exception ex) {
                System.out.println(ex);
                ex.printStackTrace();
                Toast.makeText(this, "Se ha producido un error : " + ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void guardarDatos() {
        /*   final ViewModelProvider vmp = new ViewModelProvider(this);
         *//* this.compraViewModel=vmp.get(CompraViewModel.class);*/
        Compra compraNueva = new Compra();
        compraNueva.setId_producto(producto);
        compraNueva.setId_usuario(usuario);
        envioElegido = Tipo_envio.datosTipoEnvio(tipoEnvioElegido);
        compraNueva.setTipo_Envio(envioElegido);
        compraNueva.setPrecio_compra(precioFinal);

        LocalDateTime now = LocalDateTime.now();
        ZoneOffset offset = ZoneId.systemDefault().getRules().getOffset(now);
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-mm-dd");
        compraNueva.setFecha_compra(new Date(now.toInstant(offset).toEpochMilli()));


        CompraViewModel compraViewModel = new ViewModelProvider(this).get(CompraViewModel.class);
        compraViewModel.guardarCompra(compraNueva).observe(this, response -> {
            successMessage("No olvides revisar tus compras en 'Mis compras'");
            /*Intent intent = new Intent(getApplicationContext(), home.class);
            startActivity(intent);*/
        });

     /*   s.observe(this, compraGenericResponse -> {
            successMessage("ha ido bien!");
            Intent intent = new Intent(getApplicationContext(), HomeFragment.class);
            startActivity(intent);
        });
        */

    }

    public void successMessage(String message) {
        Handler handler = new Handler();
        new SweetAlertDialog(this,
                SweetAlertDialog.SUCCESS_TYPE).setTitleText("¡Compra realizada!")
                .setContentText(message).show();
        int tiempoTranscurrir = 3000; //1 segundo, 1000 millisegundos.
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //***Aquí agregamos el proceso a ejecutar.

                Intent intent = new Intent(getApplicationContext(), home.class);
                startActivity(intent);

                handler.removeCallbacks(null);
            }
        }, tiempoTranscurrir );//define el tiemp
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
