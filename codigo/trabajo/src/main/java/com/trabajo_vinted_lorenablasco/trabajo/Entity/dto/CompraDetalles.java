package com.trabajo_vinted_lorenablasco.trabajo.Entity.dto;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto;
import com.trabajo_vinted_lorenablasco.trabajo.Entity.Tipo_envio;
import com.trabajo_vinted_lorenablasco.trabajo.Entity.Usuario;

import java.sql.Date;

public class CompraDetalles {
    private int id_usuario;
    private String email;
    private String nombre_tipo_envio;
    private String nombre_producto;

    private double precio;

    private Date fecha_compra;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre_tipo_envio() {
        return nombre_tipo_envio;
    }

    public void setNombre_tipo_envio(String nombre_tipo_envio) {
        this.nombre_tipo_envio = nombre_tipo_envio;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }
}