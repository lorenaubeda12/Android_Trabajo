package com.example.vinted_lorena.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted_lorena.Entity.service.Producto;
import com.example.vinted_lorena.R;
import com.example.vinted_lorena.ui.home.HomeFragment;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {
    private List<Producto> productoList;

    public ProductoAdapter(List<Producto> productoList, HomeFragment homeFragment, HomeFragment fragment) {
        this.productoList = productoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem(this.productoList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.productoList.size();
    }

    public void updateItems(List<Producto> producto) {
        this.productoList.clear();
        this.productoList.addAll(producto);
        this.notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setItem(final Producto producto) {
            ImageView imgProducto = (ImageView)  itemView.findViewById(R.id.imgProducto);
            TextView nombreProducto = itemView.findViewById(R.id.nombreProducto);
            TextView descipcionProducto = itemView.findViewById(R.id.descrip);
            Button btnComprar = itemView.findViewById(R.id.btnVer);

            nombreProducto.setText(producto.getNombre_producto());
            descipcionProducto.setText(producto.getDescripcion());

            btnComprar.setOnClickListener(v -> {
                Toast.makeText(itemView.getContext(), "Producto", Toast.LENGTH_SHORT).show();
            });

        }
    }

}
