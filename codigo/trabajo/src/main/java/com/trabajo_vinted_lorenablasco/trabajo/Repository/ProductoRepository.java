package com.trabajo_vinted_lorenablasco.trabajo.Repository;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto;
import com.trabajo_vinted_lorenablasco.trabajo.Entity.dto.ValoracionesProducto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto, Integer> {
    @Query("SELECT P  FROM Producto P")
    Iterable<com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto> listarProductos();

    @Query("SELECT P  FROM Producto P WHERE P.id_usuario.id = :id ")
    Iterable<com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto> listarProductosMios(int id);

    @Query("SELECT P  FROM Producto P WHERE P.id=:id")
    Iterable<com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto> producto(int id);


    @Query("SELECT P  FROM Producto P WHERE P.categoria=:categoria")
    Iterable<com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto> listarProductosPorCategoria(int categoria);


}
