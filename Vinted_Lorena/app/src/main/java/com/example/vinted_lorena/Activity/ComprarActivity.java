package com.example.vinted_lorena.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vinted_lorena.Entity.service.Producto;
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

public class ComprarActivity extends AppCompatActivity {

    private ImageView imgProductoDetalle;
    private Button btnComprar;
    private TextView tvNombreProducto, tvPrecioProducto, tvDescripcionProducto;

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
        this.imgProductoDetalle = findViewById(R.id.productoComprar);
        this.btnComprar = findViewById(R.id.btnPagar);
        this.tvNombreProducto = findViewById(R.id.nombreProductoComprar);
        this.tvPrecioProducto = findViewById(R.id.PrecioProductoComprar);
        this.tvDescripcionProducto = findViewById(R.id.descripcionProductoComprar);

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
}
