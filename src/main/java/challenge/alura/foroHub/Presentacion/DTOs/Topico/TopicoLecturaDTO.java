package challenge.alura.foroHub.Presentacion.DTOs.Topico;

import challenge.alura.foroHub.Dominio.Topico;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TopicoLecturaDTO(

         Integer id,

         String titulo,

         String mensaje,

         LocalDate fecha,

         Integer usuario_id,

         Integer curso_id
) {

    public TopicoLecturaDTO(Topico topico){
        this( topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(),
                topico.getUsuario().getId(),
                topico.getCurso().getId() );
    }

}
