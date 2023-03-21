package com.trabajo_vinted_lorenablasco.trabajo.Repository;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto;
import com.trabajo_vinted_lorenablasco.trabajo.Entity.Valoracion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Valoracion_Repository extends CrudRepository<Valoracion, Integer> {
@Query("SELECT V  FROM Valoracion V WHERE V.id_producto=:idProducto")
    Iterable<Valoracion>verValoracion(int idProducto);




}
