package com.trabajo_vinted_lorenablasco.trabajo.Service;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Producto;
import com.trabajo_vinted_lorenablasco.trabajo.Entity.Valoracion;
import com.trabajo_vinted_lorenablasco.trabajo.Repository.Compra_Repository;
import com.trabajo_vinted_lorenablasco.trabajo.Repository.Valoracion_Repository;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import static com.trabajo_vinted_lorenablasco.trabajo.utils.Global.*;

@Service
@Transactional
public class ValoracionService {
    private final Valoracion_Repository valoracionRepository;

    public ValoracionService(Valoracion_Repository compraRepository) {
        this.valoracionRepository = compraRepository;
    }


    public GenericResponse verValoracionProducto(int id){
        return  new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,this.valoracionRepository.verValoracion(id));

    }

    public GenericResponse guardarValoracionProducto(Valoracion v) {
        return new GenericResponse(TIPO_DATA, RPTA_OK, "Valoración añadida correctamente", this.valoracionRepository.save(v));
    }



}
