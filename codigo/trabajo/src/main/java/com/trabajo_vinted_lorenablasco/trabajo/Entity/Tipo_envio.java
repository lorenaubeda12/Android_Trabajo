package com.trabajo_vinted_lorenablasco.trabajo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tipo_envio {
    @Id
    private int id_tipo_envio;
    @Column
    private  String nombre_tipo_envio;
    @Column
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
