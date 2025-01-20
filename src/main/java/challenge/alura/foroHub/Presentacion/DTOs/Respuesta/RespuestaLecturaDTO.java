package challenge.alura.foroHub.Presentacion.DTOs.Respuesta;

import challenge.alura.foroHub.Dominio.Respuesta;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record RespuestaLecturaDTO(

        Integer id,

        String comentario,

        LocalDate fecha,

        Integer usuario_id,

        Integer topico_id
) {

    public RespuestaLecturaDTO(Respuesta respuesta){
        this(respuesta.getId(), respuesta.getComentario(), respuesta.getFecha(),
                respuesta.getUsuario().getId(), respuesta.getTopico().getId());
    }

}
