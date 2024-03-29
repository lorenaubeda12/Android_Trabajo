package com.trabajo_vinted_lorenablasco.trabajo.Repository;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface Usuario_Repository extends CrudRepository<Usuario,Integer> {

    @Query("SELECT U FROM Usuario U WHERE U.email=:correo AND U.contrasena=:password")
    Optional<Usuario> login(String correo, String password);

    @Query("SELECT EXISTS(SELECT U.id FROM Usuario U WHERE U.email=:email)")
    boolean existByEmail(String email);
}






/*U identificador tabla usuario*/

