package com.trabajo_vinted_lorenablasco.trabajo.Service;

import com.trabajo_vinted_lorenablasco.trabajo.Repository.Categoria_Repository;
import com.trabajo_vinted_lorenablasco.trabajo.Repository.Compra_Repository;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.trabajo_vinted_lorenablasco.trabajo.utils.Global.*;

@Service
@Transactional
public class CompraService {
    private final Compra_Repository compraRepository;

    public CompraService(Compra_Repository compraRepository) {
        this.compraRepository = compraRepository;
    }


    public GenericResponse listarMisCompras(int id){
        return  new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,this.compraRepository.listarMisCompras(id));

    }



}
