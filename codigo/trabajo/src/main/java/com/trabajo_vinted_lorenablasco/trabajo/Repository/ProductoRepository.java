package com.trabajo_vinted_lorenablasco.trabajo.Repository;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto;
import com.trabajo_vinted_lorenablasco.trabajo.Entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
@Query("SELECT P  FROM Producto P")
    Iterable<Producto>listarProductos();

    @Query("SELECT P  FROM Producto P WHERE P.id_usuario.id = :id ")
    Iterable<Producto> listarProductosMios(int id);

    @Query("SELECT P  FROM Producto P WHERE P.id=:id")
    Iterable<Producto> producto(int id);


    @Query("SELECT P  FROM Producto P WHERE P.categoria=:categoria")
    Iterable<Producto> listarProductosPorCategoria(int categoria);

}
