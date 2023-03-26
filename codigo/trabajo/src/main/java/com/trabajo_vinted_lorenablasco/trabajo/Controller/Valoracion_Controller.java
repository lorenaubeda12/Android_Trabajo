package com.trabajo_vinted_lorenablasco.trabajo.Controller;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Compra;
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




    @PostMapping("")
    public GenericResponse crearValoracion(@RequestBody Valoracion valoracion){
        return this.service.guardarValoracion(valoracion);
    }
}

