package com.example.vinted_lorena.Entity.service;

import java.util.ArrayList;

public class GenerarPedidoDTO {
    private Compra pedido;
    private Producto producto;
    private Usuario cliente;

    public GenerarPedidoDTO() {
        this.pedido = new Compra();
        this.producto = new Producto();
        this.cliente = new Usuario();
    }

    public Compra getPedido() {
        return pedido;
    }

    public void setPedido(Compra pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
}
