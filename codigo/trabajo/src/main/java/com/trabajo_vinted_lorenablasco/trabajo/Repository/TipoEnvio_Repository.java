package com.trabajo_vinted_lorenablasco.trabajo.Repository;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Categoria;
import com.trabajo_vinted_lorenablasco.trabajo.Entity.Tipo_envio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TipoEnvio_Repository extends CrudRepository<Tipo_envio, Integer> {
@Query("SELECT T  FROM Tipo_envio T")
    Iterable<Tipo_envio>listarTiposDeEnvio();
    @Query("SELECT T  FROM Tipo_envio T WHERE T.id_tipo_envio=:tipoEnvio")
    Tipo_envio elegirTipoEnvio(int tipoEnvio);

    @Query("SELECT T.precio  FROM Tipo_envio T WHERE T.id_tipo_envio=:tipoEnvio")
    Iterable<Tipo_envio>precioEnvio(int tipoEnvio);


}
