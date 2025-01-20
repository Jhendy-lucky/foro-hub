package challenge.alura.foroHub.Presentacion.DTOs.Curso;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoRegistroDTO (

         @NotBlank(message = "${curso.nombre.requerido}")
         String nombre,

         @NotNull(message = "${curso.cantidadEstudiantes.requerido}")
         @Min(value = 5, message = "${curso.cantidadEstudiantes.min}")
         Integer cantidadEstudiantes
) {
}
