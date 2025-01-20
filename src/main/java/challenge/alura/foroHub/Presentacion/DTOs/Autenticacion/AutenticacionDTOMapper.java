package challenge.alura.foroHub.Presentacion.DTOs.Autenticacion;

import challenge.alura.foroHub.Dominio.Usuario;

public class AutenticacionDTOMapper {

    public static Usuario convertirAutenticacionDTOAUsuario(AutenticacionDTO autenticacionDTO){
        return new Usuario(autenticacionDTO.nombreUsuario(), autenticacionDTO.contrasenia());
    }
}
