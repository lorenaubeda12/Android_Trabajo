package com.trabajo_vinted_lorenablasco.trabajo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Valoracion {
    @Id
    private int id_Valoracion;
    @Column
    private int id_producto;
    @Column
    private int  id_usuario;
    @Column
    private int id_compra;
    @Column
    private int valoracion;

    public int getId_Valoracion() {
        return id_Valoracion;
    }

    public void setId_Valoracion(int id_Valoracion) {
        this.id_Valoracion = id_Valoracion;
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

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
}
