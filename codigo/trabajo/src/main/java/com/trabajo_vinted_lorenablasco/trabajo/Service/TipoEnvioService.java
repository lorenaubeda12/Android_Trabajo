package com.trabajo_vinted_lorenablasco.trabajo.Service;

import com.trabajo_vinted_lorenablasco.trabajo.Repository.Categoria_Repository;
import com.trabajo_vinted_lorenablasco.trabajo.Repository.TipoEnvio_Repository;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import static com.trabajo_vinted_lorenablasco.trabajo.utils.Global.*;

@Service
@Transactional
public class TipoEnvioService {
    private final TipoEnvio_Repository envioRepository;

    public TipoEnvioService(TipoEnvio_Repository envioRepository) {
        this.envioRepository = envioRepository;
    }


    public GenericResponse listarTiposEnvio(){
        return  new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,this.envioRepository.listarTiposDeEnvio());

    }

    public GenericResponse listarTiposEnvioElegido(int idEnvio){
        return  new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,this.envioRepository.elegirTipoEnvio(idEnvio));

    }


    public GenericResponse precioEnvio(int idEnvio){
        return  new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,this.envioRepository.precioEnvio(idEnvio));

    }


}
