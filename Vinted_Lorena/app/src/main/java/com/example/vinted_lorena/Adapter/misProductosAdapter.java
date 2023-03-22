package com.example.vinted_lorena.Adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted_lorena.Entity.service.Producto;
import com.example.vinted_lorena.R;
import com.example.vinted_lorena.ui.gallery.GalleryFragment;
import com.example.vinted_lorena.ui.home.HomeFragment;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class misProductosAdapter extends RecyclerView.Adapter<misProductosAdapter.ViewHolder> {

    private final List<Producto> misProductos;

    public misProductosAdapter(List<Producto> productoList, GalleryFragment homeFragment, GalleryFragment fragment) {
        this.misProductos = productoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.misproductos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem(this.misProductos.get(position));
    }

    public void updateItem(List<Producto> productos) {
        this.misProductos.clear();
        this.misProductos.addAll(productos);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.misProductos.size();
    }

    public String generateUrl(String s) {
        String[] p = s.split("/");
        String link = "https://drive.google.com/uc?export=download&id=" + p[5];
        return link;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setItem(final Producto producto) {
            /* ImageView imgProducto = (ImageView)  itemView.findViewById(R.id.imgProducto);*/

            String ulrImage = generateUrl(producto.getImagen());
            Uri uri = Uri.parse(ulrImage);
            SimpleDraweeView draweeView = (SimpleDraweeView) itemView.findViewById(R.id.imgProductoMio);
            draweeView.setImageURI(uri);


            TextView nombreProducto = itemView.findViewById(R.id.nombreProductoMio);
            TextView descipcionProducto = itemView.findViewById(R.id.MiProductodescrip);
            Button btnVerProducto = itemView.findViewById(R.id.btnVer_misproductos);
            TextView precioProducto = itemView.findViewById(R.id.precioProductoMio);


            /*  Picasso.get().load(producto.getImagen()).resize(50,50).centerCrop().into(imgProducto);*/
            nombreProducto.setText(producto.getNombre_producto());
            descipcionProducto.setText(producto.getDescripcion());
            precioProducto.setText(String.valueOf(producto.getPrecio()) + "€");
            btnVerProducto.setOnClickListener(v -> {
                Toast.makeText(itemView.getContext(), "Producto", Toast.LENGTH_SHORT).show();
            });

        }
    }



}