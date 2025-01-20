package challenge.alura.foroHub.Presentacion.DTOs.Respuesta;

import challenge.alura.foroHub.Dominio.Respuesta;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class RespuestaMapperDTO {

    public static Page<RespuestaLecturaDTO> convertirRespuestasARespuestasLecturaDTO(Page<Respuesta> respuestas) {
        return respuestas.map(RespuestaLecturaDTO::new);
    }

    public static Respuesta convertirRepuestaRegistroDTOARegistro(RespuestaRegistroDTO respuestaRegistroDTO){
        return new Respuesta(respuestaRegistroDTO);
    }

}
