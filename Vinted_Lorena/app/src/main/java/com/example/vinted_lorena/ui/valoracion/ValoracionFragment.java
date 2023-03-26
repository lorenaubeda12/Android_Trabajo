package com.example.vinted_lorena.ui.valoracion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted_lorena.Adapter.CompraAdapter;
import com.example.vinted_lorena.Adapter.ProductoValoradosAdapter;
import com.example.vinted_lorena.Communication.Communication;
import com.example.vinted_lorena.Entity.service.Usuario;
import com.example.vinted_lorena.R;
import com.example.vinted_lorena.databinding.FragmentSlideshowBinding;
import com.example.vinted_lorena.ui.slideshow.SlideshowViewModel;
import com.example.vinted_lorena.utilis.DateSerializer;
import com.example.vinted_lorena.utilis.TimeSerializer;
import com.example.vinted_lorena.view_model.CompraViewModel;
import com.example.vinted_lorena.view_model.ProductoViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class ValoracionFragment extends Fragment implements Communication {
    private ProductoViewModel productoViewModel;
    private RecyclerView rcvProductos;
    private ProductoValoradosAdapter adapter;

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_valoracion, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        initViewModel();
        initAdapter();
        loadData();
    }

    private void init(View v) {
        rcvProductos = v.findViewById(R.id.rcvProductosValorados);
    }

    private void initAdapter() {
        adapter = new ProductoValoradosAdapter(new ArrayList<>(), this, this, this);
        rcvProductos.setLayoutManager(new GridLayoutManager(getContext(), 1));
        rcvProductos.setAdapter(adapter);
    }

    private void initViewModel() {
        productoViewModel = new ViewModelProvider(this).get(ProductoViewModel.class);
    }

    private void loadData() {
        final Gson g = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateSerializer())
                .registerTypeAdapter(Time.class, new TimeSerializer())
                .create();

        this.productoViewModel.diezProductosMasValorados().observe(getViewLifecycleOwner(), response -> {
            adapter.updateItem(response.getBody());
        });
    }


    @Override
    public void showDetails(Intent i) {
        getActivity().startActivity(i);
        getActivity().overridePendingTransition(R.anim.left_in, R.anim.left_out);

    }

    @Override
    public void exportInvoice(int idCli, int idOrden, String fileName) {

    }
}