package challenge.alura.foroHub.Presentacion.DTOs.Topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TopicoActualizacionDTO(

        @NotNull
        Integer id,

        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotNull
        LocalDate fecha
) {
}
