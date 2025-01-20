package challenge.alura.foroHub.Presentacion.DTOs.Autenticacion;

import jakarta.validation.constraints.NotBlank;

public record AutenticacionDTO(

        @NotBlank
        String nombreUsuario,

        @NotBlank
        String contrasenia
) {
}
