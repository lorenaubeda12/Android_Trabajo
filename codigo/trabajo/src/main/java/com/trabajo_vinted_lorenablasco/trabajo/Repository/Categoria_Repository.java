package com.trabajo_vinted_lorenablasco.trabajo.Repository;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Categoria;
import com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Categoria_Repository extends CrudRepository<Categoria, Integer> {
@Query("SELECT C  FROM Categoria C")
    Iterable<Categoria>listarCategorias();


}
