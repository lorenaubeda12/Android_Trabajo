package com.trabajo_vinted_lorenablasco.trabajo.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Compra {
    @Id
    private int id_compra;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_producto"  , referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Producto id_producto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_usuario" , referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario id_usuario;
    @Column
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date fecha_compra;
    @Column
    private  double precio_compra;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="tipo_Envio" , referencedColumnName = "id_tipo_envio")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Tipo_envio tipo_Envio;

    private boolean estValorada;
    

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }



    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
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

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    public Tipo_envio getTipo_Envio() {
        return tipo_Envio;
    }

    public void setTipo_Envio(Tipo_envio tipo_Envio) {
        this.tipo_Envio = tipo_Envio;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }


}
