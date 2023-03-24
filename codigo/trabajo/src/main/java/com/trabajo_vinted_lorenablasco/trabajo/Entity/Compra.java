package com.trabajo_vinted_lorenablasco.trabajo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Compra {
    @Id
    private int id_compra;
    @Column
    private int id_producto;
    @Column
    private int id_usuario;
    @Column
    private Date fecha_compra;
    @Column
    private  double precio_compra;
    @Column
    private int tipo_Envio;


    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public int getTipoEnvio() {
        return tipo_Envio;
    }

    public void setTipoEnvio(int tipoEnvio) {
        this.tipo_Envio = tipoEnvio;
    }
}
