package com.trabajo_vinted_lorenablasco.trabajo.Repository;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Compra;
import com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto;
import com.trabajo_vinted_lorenablasco.trabajo.Entity.Valoracion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Valoracion_Repository extends CrudRepository<Valoracion, Integer> {
    @Query(value = "SELECT v.id_producto " +
            "FROM Valoracion v " +
            "GROUP BY v.id_producto.id " +
            " ORDER BY COUNT(v.id_producto.id)")
    Iterable<Producto> listarMasValorados();
}
