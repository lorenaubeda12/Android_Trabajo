package com.trabajo_vinted_lorenablasco.trabajo.Controller;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Usuario;
import com.trabajo_vinted_lorenablasco.trabajo.Service.UsuarioService;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/registro")
public class ClienteController {
    private final UsuarioService servicio;

    public ClienteController(UsuarioService servicio) {
        this.servicio = servicio;
    }

    @PostMapping("")
    public GenericResponse save(@Validated @RequestBody Usuario u) {
        return this.servicio.save(u);
    }

    @PutMapping("/{id}")
    public GenericResponse actualizar(@PathVariable int id, @Validated @RequestBody Usuario u) {
        u.setId(id);
        return this.servicio.save(u);
    }
}
