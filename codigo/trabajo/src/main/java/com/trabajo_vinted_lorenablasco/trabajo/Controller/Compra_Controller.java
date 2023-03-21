package com.trabajo_vinted_lorenablasco.trabajo.Controller;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Compra;
import com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto;
import com.trabajo_vinted_lorenablasco.trabajo.Entity.Valoracion;
import com.trabajo_vinted_lorenablasco.trabajo.Service.CategoriaService;
import com.trabajo_vinted_lorenablasco.trabajo.Service.CompraService;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static com.trabajo_vinted_lorenablasco.trabajo.utils.Global.RPTA_OK;
import static com.trabajo_vinted_lorenablasco.trabajo.utils.Global.TIPO_DATA;

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


    @PostMapping("")
    public GenericResponse crearCompra(@RequestBody Compra c){
        return this.service.guardarCompra(c);
    }
}

