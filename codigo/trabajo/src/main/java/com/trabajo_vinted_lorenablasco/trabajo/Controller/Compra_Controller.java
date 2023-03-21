package com.trabajo_vinted_lorenablasco.trabajo.Controller;

import com.trabajo_vinted_lorenablasco.trabajo.Service.CategoriaService;
import com.trabajo_vinted_lorenablasco.trabajo.Service.CompraService;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("api/compras")
public class Compra_Controller {
    private final CompraService service;

    public Compra_Controller(CompraService service) {
        this.service = service;
    }


    @GetMapping("/todas")
    public GenericResponse listarCompras(int id) {
        return this.service.listarMisCompras(id);
    }

}

