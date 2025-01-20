package challenge.alura.foroHub.Negocios.Interfaces;

import challenge.alura.foroHub.Dominio.Usuario;

import java.util.List;

public interface IUsuario {

    public boolean registrarUsuario(Usuario usuario);

    public List<Usuario> obtenerUsuarios();

    public String obtenerTokenJWT(Usuario usuario);
}
