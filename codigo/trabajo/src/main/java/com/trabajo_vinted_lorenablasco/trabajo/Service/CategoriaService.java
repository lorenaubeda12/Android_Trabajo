package com.trabajo_vinted_lorenablasco.trabajo.Service;

import com.trabajo_vinted_lorenablasco.trabajo.Repository.ProductoRepository;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import static com.trabajo_vinted_lorenablasco.trabajo.utils.Global.*;

@Service
@Transactional
public class CategoriaService {
    private final ProductoRepository productoRepository;

    public CategoriaService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    public GenericResponse listarCategorias(){
        return  new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,this.productoRepository.listarProductos());

    }


}
