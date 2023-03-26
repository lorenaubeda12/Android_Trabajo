package com.trabajo_vinted_lorenablasco.trabajo.Controller;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto;
import com.trabajo_vinted_lorenablasco.trabajo.Service.ProductoService;
import com.trabajo_vinted_lorenablasco.trabajo.Service.ValoracionService;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/producto")
public class ProductoController {
    private final ProductoService service;
    private final ValoracionService valoracionService;

    public ProductoController(ProductoService service, ValoracionService valoracionService) {
        this.service = service;
        this.valoracionService = valoracionService;
    }


    @GetMapping("/todos")
    public GenericResponse listarProductos() {
        return this.service.listarProductos();
    }

    @GetMapping("/misProductos/{id}")
    public GenericResponse<List<Producto>> misProductos(@PathVariable int id) {
        return this.service.listarProductosmios(id);
    }

    @PostMapping("")
    public GenericResponse guardar(@RequestBody Producto p) {
        return this.service.guardarProducto(p);
    }

    @GetMapping("/productoCategoria/{id}")
    public GenericResponse verProductosPorCategoria(@PathVariable int id) {
        return this.service.listarProductosPorCategoria(id);
    }


    @GetMapping("/productoValoraciones")
    public GenericResponse verProductosPorValoracion() {
        return this.valoracionService.listar10ProductosMejorValorados();
    }

    @GetMapping("/producto/{id}")
    public GenericResponse productoElegidoVer(@PathVariable int id) {
        return this.service.VerProductoElegido(id);
    }
}

