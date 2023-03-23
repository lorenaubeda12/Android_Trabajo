package com.example.vinted_lorena.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vinted_lorena.Communication.Communication;
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

public class CompraActivity extends AppCompatActivity {
    private ImageView imgProductoDetalle;
    private Button btnComprar;
    private TextView tvNombreProducto, tvPrecioProducto, tvDescripcionProducto, tvDireccion;


    private final Communication communication;
    final Gson g = new GsonBuilder()
            .registerTypeAdapter(Date.class, new DateSerializer())
            .registerTypeAdapter(Time.class, new TimeSerializer())
            .create();

    Producto producto;

    public CompraActivity(Communication communication) {
        this.communication = communication;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
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
        this.imgProductoDetalle = findViewById(R.id.productoCompra);
        this.btnComprar = findViewById(R.id.btnFinal);
        this.tvNombreProducto = findViewById(R.id.nombreProductoCompra);
        this.tvPrecioProducto = findViewById(R.id.PrecioProductoCompra);
        this.tvDescripcionProducto = findViewById(R.id.descripcionProductoCompra);
        this.tvDireccion = findViewById(R.id.Direccion);

    }

    public String generateUrl(String s) {
        String[] p = s.split("/");
        String link = "https://drive.google.com/uc?export=download&id=" + p[5];
        return link;
    }


    private void loadData() {
        final String detalleString = this.getIntent().getStringExtra("usuario");
        final String producot = this.getIntent().getStringExtra("compraProducto");
        if (detalleString != null && producot != null) {
            producto = g.fromJson(producot, Producto.class);
            Usuario usuario = g.fromJson(detalleString, Usuario.class);

            this.tvNombreProducto.setText(producto.getNombre_producto());
            this.tvPrecioProducto.setText(String.valueOf(producto.getPrecio()) + "€");
            this.tvDescripcionProducto.setText(producto.getDescripcion());
            if (detalleString != null) {
                producto = g.fromJson(detalleString, Producto.class);
                this.tvNombreProducto.setText(producto.getNombre_producto());
                this.tvPrecioProducto.setText(String.valueOf(producto.getPrecio()) + "€");
                this.tvDescripcionProducto.setText(producto.getDescripcion());
                this.tvDireccion.setText(usuario.getDireccion());
                String ulrImage = generateUrl(producto.getImagen());
                Picasso picasso = new Picasso.Builder(this)
                        .downloader(new OkHttp3Downloader(ConfigApi.getClient()))
                        .build();
                picasso.load(ulrImage)
                        .error(cn.pedant.SweetAlert.R.drawable.error_center_x)
                        .into(this.imgProductoDetalle);
            } else {
                System.out.println("Error al obtener los detalles del producto");
            }

            btnComprar.setOnClickListener(v -> {


            });

        }
    }
}
