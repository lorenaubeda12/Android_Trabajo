package com.trabajo_vinted_lorenablasco.trabajo.Service;

import com.trabajo_vinted_lorenablasco.trabajo.Entity.Compra;
import com.trabajo_vinted_lorenablasco.trabajo.Entity.Valoracion;
import com.trabajo_vinted_lorenablasco.trabajo.Repository.ProductoRepository;
import com.trabajo_vinted_lorenablasco.trabajo.Repository.Valoracion_Repository;
import com.trabajo_vinted_lorenablasco.trabajo.utils.GenericResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import static com.trabajo_vinted_lorenablasco.trabajo.utils.Global.*;
@Service
@Transactional
public class ValoracionService {
    private final Valoracion_Repository valoracionRepository;

    public ValoracionService(Valoracion_Repository valoracionRepository) {
        this.valoracionRepository = valoracionRepository;
    }
    public GenericResponse guardarValoracion(Valoracion valoracion) {
        return new GenericResponse(TIPO_DATA, RPTA_OK, "Compra realizada", this.valoracionRepository.save(valoracion));
    }
    public GenericResponse listar10ProductosMejorValorados() {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.valoracionRepository.listarMasValorados());
    }
}
