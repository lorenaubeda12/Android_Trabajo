package com.trabajo_vinted_lorenablasco.trabajo.Service;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto;
import com.trabajo_vinted_lorenablasco.trabajo.Entity.Usuario;
import com.trabajo_vinted_lorenablasco.trabajo.Repository.ProductoRepository;
import com.trabajo_vinted_lorenablasco.trabajo.Repository.Usuario_Repository;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import static com.trabajo_vinted_lorenablasco.trabajo.utils.Global.*;

@Service
@Transactional
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    public GenericResponse listarProductos() {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.productoRepository.listarProductos());

    }

    public GenericResponse listarProductosmios(int usuario) {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.productoRepository.listarProductosMios(usuario));

    }

    public GenericResponse guardarProducto(Producto p) {
        return new GenericResponse(TIPO_DATA, RPTA_OK, "Producto añadido", this.productoRepository.save(p));
    }


    public GenericResponse VerProductoElegido(int idproducto) {
        return new GenericResponse(TIPO_DATA, RPTA_OK, "Producto añadido", this.productoRepository.producto(idproducto));
    }
    public GenericResponse listar10ProductosMejorValorados(Iterable<Integer> idsValoradas) {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.productoRepository.productosMejorValorados(idsValoradas));
    }
    public Iterable<Integer> listar10idsMejorValoradas() {
        return this.productoRepository.idsMejorValoradas();
    }

    public GenericResponse listarProductosPorCategoria(int id) {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.productoRepository.listarProductosPorCategoria( id));

    }

}


