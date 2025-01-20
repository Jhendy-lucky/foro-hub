package challenge.alura.foroHub.Presentacion.DTOs.Respuesta;

import challenge.alura.foroHub.Dominio.Topico;
import challenge.alura.foroHub.Dominio.Usuario;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record RespuestaRegistroDTO(


         @NotBlank(message = "${respuesta.comentario.requerido}")
         String comentario,

         @NotNull(message = "${respuesta.fecha.requerido}")
         @PastOrPresent(message = "${respuesta.fecha.pasadoPresente}")
         LocalDate fecha,

         @NotNull(message = "${respuesta.usuarioID.requerido}")
         @Min(value = 1, message = "${respuesta.usuarioID.min}")
         Integer usuario_id,

         @NotNull(message = "${respuesta.usuarioID.requerido}")
         @Min(value = 1, message = "${respuesta.topicoID.min }")
         Integer topico_id
) {
}
