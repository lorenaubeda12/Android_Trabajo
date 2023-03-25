package com.example.vinted_lorena.Adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted_lorena.Entity.service.Compra;
import com.example.vinted_lorena.R;
import com.example.vinted_lorena.ui.slideshow.SlideshowFragment;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class CompraAdapter extends RecyclerView.Adapter<CompraAdapter.ViewHolder> {

    private final List<Compra> compras;

    public CompraAdapter(List<Compra> compras, SlideshowFragment slideshowFragment, SlideshowFragment fragment) {
        this.compras= new ArrayList<>();
        compras.addAll(compras);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detalle_compras, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem(this.compras.get(position));

    }

    public void updateItems(List<Compra> detalles){
        this.compras.clear();
        this.compras.addAll(detalles);
        this.notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return compras.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }


        public void setItem(final Compra c) {
            final TextView txtNombreCompra, txtDescipCompra, txtPrecioCompra, txtCodigoCompra, txtVendedorCompra;
            final ImageView img;
            txtCodigoCompra = this.itemView.findViewById(R.id.txtValueCodDetailPurchases);
            txtDescipCompra = this.itemView.findViewById(R.id.txtDesCompra);
            txtNombreCompra = this.itemView.findViewById(R.id.txtProductoComprado);
            txtVendedorCompra = this.itemView.findViewById(R.id.txtVendedorCompra);
            txtPrecioCompra = this.itemView.findViewById(R.id.txtValuePrecio);

            System.out.println("Fecha: "+c.getFecha_compra().toString());

            String ulrImage = generateUrl(c.getId_producto().getImagen());
            Uri uri = Uri.parse(ulrImage);
            SimpleDraweeView draweeView = (SimpleDraweeView) itemView.findViewById(R.id.imgCompra);
            draweeView.setImageURI(uri);


            txtCodigoCompra.setText(""+c.getId_compra());
            txtDescipCompra.setText(c.getId_producto().getDescripcion());
            txtNombreCompra.setText(c.getId_producto().getNombre_producto());
            txtVendedorCompra.setText(c.getId_usuario().getnombreCompleto());
            txtPrecioCompra.setText(String.valueOf(c.getPrecio_compra())+"€");

        }
    }

    public String generateUrl(String s) {
        String[] p = s.split("/");
        String link = "https://drive.google.com/uc?export=download&id=" + p[5];
        return link;
    }
}
