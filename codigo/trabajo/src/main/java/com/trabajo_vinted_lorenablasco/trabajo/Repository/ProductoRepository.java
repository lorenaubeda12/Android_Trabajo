package com.trabajo_vinted_lorenablasco.trabajo.Repository;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto;
import com.trabajo_vinted_lorenablasco.trabajo.Entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
@Query("SELECT P  FROM Producto P")
    Iterable<Producto>listarProductos();

    @Query("SELECT P  FROM Producto P WHERE P.id_usuario=:id_usuario")
    Iterable<Producto> listarProductosMios(int id_usuario);


    @Query("SELECT P  FROM Producto P WHERE P.categoria=:categoria")
    Iterable<Producto> listarProductosPorCategoria(int categoria);

}
