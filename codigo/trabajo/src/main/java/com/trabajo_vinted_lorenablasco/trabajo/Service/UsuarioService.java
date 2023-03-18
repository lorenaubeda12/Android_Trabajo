package com.trabajo_vinted_lorenablasco.trabajo.Service;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Usuario;
import com.trabajo_vinted_lorenablasco.trabajo.Repository.Usuario_Repository;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

import static com.trabajo_vinted_lorenablasco.trabajo.utils.Global.*;

@Service
@Transactional
public class UsuarioService {
    private final Usuario_Repository repository;

    public UsuarioService(Usuario_Repository repository) {
        this.repository = repository;
    }
    //Método para iniciar sesión
    public GenericResponse<Usuario> login(String email, String contrasenia){
        Optional<Usuario> optU = this.repository.login(email, contrasenia);
        if(optU.isPresent()){
            return new GenericResponse<Usuario>(TIPO_AUTH, RPTA_OK, "Haz iniciado sesión correctamente", optU.get());
        }else{
            return new GenericResponse<Usuario>(TIPO_AUTH, RPTA_WARNING, "Lo sentimos, ese usuario no existe", new Usuario());
        }
    }
    //Método para guardar credenciales del usuario
    public GenericResponse guardarUsuario(Usuario u){
        Optional<Usuario> optU = this.repository.findById(u.getId());
        int idf = optU.isPresent() ? optU.get().getId() : 0;
        if(idf == 0){
            return new GenericResponse(TIPO_DATA, RPTA_OK, "Usuario Registrado Correctamente", this.repository.save(u));
        }else{
            return new GenericResponse(TIPO_DATA, RPTA_OK, "Datos del usuario actualizados", this.repository.save(u));
        }
    }
}