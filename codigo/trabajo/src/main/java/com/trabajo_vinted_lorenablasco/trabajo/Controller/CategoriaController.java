package com.trabajo_vinted_lorenablasco.trabajo.Controller;

import com.trabajo_vinted_lorenablasco.trabajo.Service.CategoriaService;
import com.trabajo_vinted_lorenablasco.trabajo.Service.ProductoService;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }


    @GetMapping("/todas")
    public GenericResponse listarCategorias() {
        return this.service.listarCategorias();
    }

}
