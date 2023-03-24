package com.trabajo_vinted_lorenablasco.trabajo.Controller;

import com.trabajo_vinted_lorenablasco.trabajo.Service.CategoriaService;
import com.trabajo_vinted_lorenablasco.trabajo.Service.TipoEnvioService;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tipoEnvio")
public class TipoEnvioController {
    private final TipoEnvioService service;

    public TipoEnvioController(TipoEnvioService service) {
        this.service = service;
    }


    @GetMapping("/tipo/{id}")
    public GenericResponse tipoEnvioElegido(@PathVariable int id) {
        return this.service.listarTiposEnvioElegido(id);
    }

    @GetMapping("/precio/{id}")
    public GenericResponse precioEnvio(@PathVariable int id) {
        return this.service.precioEnvio(id);
    }

}
