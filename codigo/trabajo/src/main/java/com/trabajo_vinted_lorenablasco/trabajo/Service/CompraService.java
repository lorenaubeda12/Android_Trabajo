package com.trabajo_vinted_lorenablasco.trabajo.Service;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Compra;
import com.trabajo_vinted_lorenablasco.trabajo.Repository.Compra_Repository;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
    public GenericResponse guardarCompra(Compra c) {
        return new GenericResponse(TIPO_DATA, RPTA_OK, "Compra realizada", this.compraRepository.save(c));
    }


}
