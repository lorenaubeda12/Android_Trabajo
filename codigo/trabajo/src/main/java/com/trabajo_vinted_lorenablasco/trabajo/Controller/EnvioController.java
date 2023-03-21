package com.trabajo_vinted_lorenablasco.trabajo.Controller;

import com.trabajo_vinted_lorenablasco.trabajo.Service.CategoriaService;
import com.trabajo_vinted_lorenablasco.trabajo.Service.TipoEnvioService;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/envio")
public class EnvioController {
    private final TipoEnvioService service;

    public EnvioController(TipoEnvioService service) {
        this.service = service;
    }


    @GetMapping("/todos")
    public GenericResponse listarEnvios() {
        return this.service.listarTiposEnvio();
    }

    @GetMapping("/elegido")
    public GenericResponse listarEnvios(int id) {
        return this.service.listarTiposEnvioElegido( id);
    }

}
