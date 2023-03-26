package com.trabajo_vinted_lorenablasco.trabajo.Entity.dto;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;

public class ValoracionesProducto {
    private com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto producto;
    private int valoraciones;

    public ValoracionesProducto(com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto producto, int valoraciones) {
        this.producto = producto;
        this.valoraciones = valoraciones;
    }

    public int getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(int valoraciones) {
        this.valoraciones = valoraciones;
    }

    public com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto getProducto() {
        return producto;
    }

    public void setProducto(com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto producto) {
        this.producto = producto;
    }
}
