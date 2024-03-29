package com.trabajo_vinted_lorenablasco.trabajo.Controller;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto;
import com.trabajo_vinted_lorenablasco.trabajo.Entity.Valoracion;
import com.trabajo_vinted_lorenablasco.trabajo.Service.CompraService;
import com.trabajo_vinted_lorenablasco.trabajo.Service.ValoracionService;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/valoracion")
public class Valoracion_Controller {
    private final ValoracionService service;

    public Valoracion_Controller(ValoracionService service) {
        this.service = service;
    }


    @GetMapping("/productoElegido")
    public GenericResponse verValoracion(int id) {
        return this.service.verValoracionProducto(id);
    }


    @PostMapping("")
    public GenericResponse guardar(@RequestBody Valoracion v){
        return this.service.guardarValoracionProducto(v);
    }
}

