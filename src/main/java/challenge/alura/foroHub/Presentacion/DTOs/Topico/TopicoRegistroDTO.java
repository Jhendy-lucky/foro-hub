package challenge.alura.foroHub.Presentacion.DTOs.Topico;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record TopicoRegistroDTO(

        @NotBlank(message = "${topico.titulo.requerido}")
        String titulo,

        @NotBlank(message = "${topico.mensaje.requerido}")
        String mensaje,

        @NotNull(message = "${topico.fecha.requerido}")
        @PastOrPresent(message = "${topico.fecha.pasadoPresente}")
        LocalDate fecha,

        @NotNull(message = "${topico.usuarioID.requerido}")
        @Min(value = 1, message = "${topico.usuarioID.min}")
        Integer usuario_id,

        @NotNull(message = "${topico.cursoID.requerido}")
        @Min(value = 1, message = "${topico.cursoID.min}")
        Integer curso_id
) {
}
