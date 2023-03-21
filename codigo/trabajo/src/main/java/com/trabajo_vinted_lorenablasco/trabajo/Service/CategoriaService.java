package com.trabajo_vinted_lorenablasco.trabajo.Service;

import com.trabajo_vinted_lorenablasco.trabajo.Repository.Categoria_Repository;
import com.trabajo_vinted_lorenablasco.trabajo.Repository.ProductoRepository;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import static com.trabajo_vinted_lorenablasco.trabajo.utils.Global.*;

@Service
@Transactional
public class CategoriaService {
    private final Categoria_Repository categoriaRepository;

    public CategoriaService(Categoria_Repository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }


    public GenericResponse listarCategorias(){
        return  new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,this.categoriaRepository.listarCategorias());

    }


}
