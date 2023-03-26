package com.trabajo_vinted_lorenablasco.trabajo.Controller;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Usuario;
import com.trabajo_vinted_lorenablasco.trabajo.Repository.ProductoRepository;
import com.trabajo_vinted_lorenablasco.trabajo.Service.ProductoService;
import com.trabajo_vinted_lorenablasco.trabajo.Service.UsuarioService;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    private final UsuarioService service;
    private final ProductoService productoService;

    public UsuarioController(UsuarioService service, ProductoService productoService) {
        this.service = service;
        this.productoService=productoService;
    }
    /*Hacer el login*/
    @PostMapping("/login")
    public GenericResponse<Usuario> login(HttpServletRequest request){
        String email = request.getParameter("email");
        String contrasenia = request.getParameter("pass");
        return this.service.login(email, contrasenia);
    }

    @PostMapping("")
    public GenericResponse guardar(@RequestBody Usuario u){
        return this.service.guardarUsuario(u);
    }
    @PutMapping("/{id}")
    public GenericResponse actualizar(@PathVariable int id, @RequestBody Usuario u){
        return  this.service.guardarUsuario(u);
    }
    @GetMapping("/vendedoresConMasProductos")
    public GenericResponse verProductosPorValoracion() {
        return this.productoService.vendedoresConMasProductos();
    }



}
