package challenge.alura.foroHub.Infraestructura.Filtros;

import challenge.alura.foroHub.Datos.UsuarioRepositorio;
import challenge.alura.foroHub.Infraestructura.Seguridad.ServicioToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FiltroSeguridadToken extends OncePerRequestFilter {

    @Autowired
    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private final ServicioToken servicioToken;

    public FiltroSeguridadToken(UsuarioRepositorio usuarioRepositorio, ServicioToken servicioToken) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.servicioToken = servicioToken;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var authHeader = request.getHeader("Authorization");

        if (authHeader != null) {
            var token = authHeader.replace("Bearer ", "");
            var nombreUsuario = servicioToken.getSubject(token);

            if (nombreUsuario != null) {

                var user = usuarioRepositorio.findByNombreUsuario(nombreUsuario);

                var authentication = new UsernamePasswordAuthenticationToken(user, null,
                        user.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}
