package com.example.vinted_lorena.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.vinted_lorena.Entity.service.Categoria;
import com.example.vinted_lorena.Entity.service.Producto;
import com.example.vinted_lorena.R;
import com.example.vinted_lorena.Repository.Categoria_Repository;
import com.example.vinted_lorena.api.ConfigApi;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CategoriaAdapter extends  ArrayAdapter<Categoria> {

    public CategoriaAdapter(@NonNull Context context, int resource, @NonNull List<Categoria> objects) {
        super(context, resource, objects);
    }

    public String generateUrl(String s) {
        String[] p = s.split("/");
        String link = "https://drive.google.com/uc?export=download&id=" + p[5];
        return link;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.varios_item, parent, false);
        }
        Categoria c = this.getItem(position);
        ImageView imgCategoria = convertView.findViewById(R.id.imgOpcion);
        TextView txtNombreCategoria= convertView.findViewById(R.id.txtNombreAccion);

        String ulrImage = generateUrl(c.getImg_categoria());
        Uri uri = Uri.parse(ulrImage);
        SimpleDraweeView draweeView = (SimpleDraweeView) convertView.findViewById(R.id.imgProductoMio);
        draweeView.setImageURI(uri);


        txtNombreCategoria.setText(c.getNombre_categoria());
        convertView.setOnClickListener(v -> {
            Intent i = new Intent(getContext(), Categoria.class);
            i.putExtra("idC", c.getId_categoria());//Obtenenmos el id de la Categoria
            getContext().startActivity(i);
        });
        return convertView;
    }
}