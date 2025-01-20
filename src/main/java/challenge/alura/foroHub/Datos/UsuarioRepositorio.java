package challenge.alura.foroHub.Datos;

import challenge.alura.foroHub.Dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    public UserDetails findByNombreUsuario(String nombreUsuario);
}
