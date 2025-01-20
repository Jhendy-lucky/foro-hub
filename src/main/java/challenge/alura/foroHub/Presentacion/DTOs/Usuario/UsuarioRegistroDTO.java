package challenge.alura.foroHub.Presentacion.DTOs.Usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRegistroDTO(

         @NotBlank(message = "${usuario.nombreUsuario.requerido}")
         String nombreUsuario,

         @NotBlank(message = "${usuario.contrasenia.requerido}")
         String contrasenia
) {


}
