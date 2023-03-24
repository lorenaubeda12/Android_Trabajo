package com.example.vinted_lorena.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vinted_lorena.Entity.service.Producto;
import com.example.vinted_lorena.Entity.service.Tipo_envio;
import com.example.vinted_lorena.Entity.service.Usuario;
import com.example.vinted_lorena.R;
import com.example.vinted_lorena.api.ConfigApi;
import com.example.vinted_lorena.utilis.DateSerializer;
import com.example.vinted_lorena.utilis.TimeSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.sql.Date;
import java.sql.Time;

public class ComprarActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageView imgProductoDetalle;
    private Button btnFinalizarCompra;
    private TextView tvNombreProducto, tvPrecioProducto, tvDescripcionProducto, tvPrecioFinal, tvVendedor;
    private Spinner tipoEnvio;

    static String elegidoEnvio;
    static int tipoEnvioElegido;
    static double precioProducto;
    static double precioFinal;
    final Gson g = new GsonBuilder()
            .registerTypeAdapter(Date.class, new DateSerializer())
            .registerTypeAdapter(Time.class, new TimeSerializer())
            .create();

    Producto producto;

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
        final String producto = this.getIntent().getStringExtra("producto");
        if (producto != null) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
            final Gson g = new GsonBuilder()
                    .registerTypeAdapter(Date.class, new DateSerializer())
                    .registerTypeAdapter(Time.class, new TimeSerializer())
                    .create();
            String usuarioJson = sp.getString("usuarioJson", null);
            if (usuarioJson != null) {

                final Usuario u = g.fromJson(usuarioJson, Usuario.class);
                this.producto = g.fromJson(producto, Producto.class);
                this.tvNombreProducto.setText(this.producto.getNombre_producto());
                this.tvPrecioProducto.setText(String.valueOf(this.producto.getPrecio()) + "€");
                this.tvDescripcionProducto.setText(this.producto.getDescripcion());
                if (producto != null) {
                    this.producto = g.fromJson(producto, Producto.class);
                    this.tvNombreProducto.setText(this.producto.getNombre_producto());
                    this.tvPrecioProducto.setText(String.valueOf(this.producto.getPrecio()) + "€");
                    this.tvDescripcionProducto.setText(this.producto.getDescripcion());
                    this.tvVendedor.setText(this.producto.getId_usuario().getnombreCompleto());
                    this.tipoEnvio.setOnItemSelectedListener(this);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tiposDeEnvio, android.R.layout.simple_spinner_item);
                    this.tipoEnvio.setAdapter(adapter);

                    precioProducto= this.producto.getPrecio();
                    this.tipoEnvio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            elegidoEnvio = parent.getItemAtPosition(position).toString();
                            if(elegidoEnvio.contains("Envio Estándar")){
                                precioFinal=precioProducto+5;
                                tipoEnvioElegido = 1;
                                tvPrecioFinal.setText(String.valueOf(precioFinal)+"€");

                            }else if(elegidoEnvio.contains("Envio Urgente")){
                                precioFinal=precioProducto+10;
                                tipoEnvioElegido = 3;
                                tvPrecioFinal.setText(String.valueOf(precioFinal)+"€");

                            }else if(elegidoEnvio.contains("Envio Certificado")){
                                precioFinal=precioProducto+6;
                                tipoEnvioElegido = 4;
                                tvPrecioFinal.setText(String.valueOf(precioFinal)+"€");
                            }else{
                                Toast.makeText(ComprarActivity.this, "Se aplicara el envio basico que tiene un costo de 2€", Toast.LENGTH_SHORT).show();
                                precioFinal=precioProducto+2;
                                tipoEnvioElegido=2;
                                tvPrecioFinal.setText(String.valueOf(precioFinal)+"€");

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


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
