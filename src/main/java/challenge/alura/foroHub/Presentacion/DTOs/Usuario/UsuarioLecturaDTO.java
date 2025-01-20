package challenge.alura.foroHub.Presentacion.DTOs.Usuario;

import challenge.alura.foroHub.Dominio.Usuario;

public record UsuarioLecturaDTO(

        Integer id,

        String nombreUsuario,

        String contrasenia

) {

    public UsuarioLecturaDTO(Usuario usuario){
        this(usuario.getId(), usuario.getNombreUsuario(), usuario.getContrasenia());
    }
}
