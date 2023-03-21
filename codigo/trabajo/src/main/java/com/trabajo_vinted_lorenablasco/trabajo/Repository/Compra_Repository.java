package com.trabajo_vinted_lorenablasco.trabajo.Repository;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Compra;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface Compra_Repository extends CrudRepository<Compra, Integer> {
    @Query("SELECT C  FROM Compra C WHERE C.id_usuario=:idUsuario")
    Iterable<Compra> listarMisCompras(int idUsuario);
}
