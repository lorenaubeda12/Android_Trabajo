package com.trabajo_vinted_lorenablasco.trabajo.Controller;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto;
import com.trabajo_vinted_lorenablasco.trabajo.Repository.ProductoRepository;
import com.trabajo_vinted_lorenablasco.trabajo.Service.ProductoService;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/producto")
public class ProductoController {
    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }


    @GetMapping("/todos")
    public GenericResponse listarProductos() {
        return this.service.listarProductos();
    }

    @GetMapping("/misProductos/{id}")
    public GenericResponse<List<Producto>> misProductos(@PathVariable int id){
        return this.service.listarProductosmios(id);
    }
    @PostMapping("")
    public GenericResponse guardar(@RequestBody Producto p){
        return this.service.guardarProducto(p);
    }


    @GetMapping("/producto/{id}")
    public GenericResponse productoElegidoVer(@PathVariable int id){
        return this.service.VerProductoElegido(id);
    }
}
