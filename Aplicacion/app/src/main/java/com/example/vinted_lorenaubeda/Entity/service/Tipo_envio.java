package com.example.vinted_lorenaubeda.Entity.service;


public class Tipo_envio {

    private int id_tipo_envio;

    private  String nombre_tipo_envio;

    private int precio;

    public int getId_tipo_envio() {
        return id_tipo_envio;
    }

    public void setId_tipo_envio(int id_tipo_envio) {
        this.id_tipo_envio = id_tipo_envio;
    }

    public String getNombre_tipo_envio() {
        return nombre_tipo_envio;
    }

    public void setNombre_tipo_envio(String nombre_tipo_envio) {
        this.nombre_tipo_envio = nombre_tipo_envio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
