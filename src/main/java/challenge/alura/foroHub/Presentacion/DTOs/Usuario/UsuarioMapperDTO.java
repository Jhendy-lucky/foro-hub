package challenge.alura.foroHub.Presentacion.DTOs.Usuario;

import challenge.alura.foroHub.Dominio.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapperDTO {

    public static Usuario convertirUsuarioRegistroDTOAUsuario(UsuarioRegistroDTO usuarioRegistroDTO){
        return new Usuario(usuarioRegistroDTO);
    }

    public static List<UsuarioLecturaDTO> convertirUsuariosAUsuariosLecturaDTO(List<Usuario> usuarios){
        return usuarios.stream()
                .map(UsuarioLecturaDTO::new)
                .collect(Collectors.toList());
    }
}


