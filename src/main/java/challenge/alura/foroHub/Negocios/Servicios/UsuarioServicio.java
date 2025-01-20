package challenge.alura.foroHub.Negocios.Servicios;

import challenge.alura.foroHub.Datos.UsuarioRepositorio;
import challenge.alura.foroHub.Dominio.Usuario;
import challenge.alura.foroHub.Infraestructura.Seguridad.ServicioToken;
import challenge.alura.foroHub.Negocios.Interfaces.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio implements IUsuario {

    @Autowired
    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final ServicioToken servicioToken;


    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio, AuthenticationManager authenticationManager, ServicioToken servicioToken) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.authenticationManager = authenticationManager;
        this.servicioToken = servicioToken;
    }

    @Override
    public boolean registrarUsuario(Usuario usuario) {
        try {
            this.usuarioRepositorio.save(usuario);
            return true;
        }catch (Exception e){
            System.out.println("Error: "+e);
            return false;
        }
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return this.usuarioRepositorio.findAll();
    }

    @Override
    public String obtenerTokenJWT(Usuario usuario) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(usuario.getUsername(),
                usuario.getPassword());

        Usuario usuarioAutenticado = (Usuario) authenticationManager.authenticate(authenticationToken).getPrincipal();


        return  servicioToken.generarTokenJWT(usuarioAutenticado);
    }
}
