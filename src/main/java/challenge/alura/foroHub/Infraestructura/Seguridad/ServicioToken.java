package challenge.alura.foroHub.Infraestructura.Seguridad;

import challenge.alura.foroHub.Dominio.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class ServicioToken {

    @Value("${api.security.secret}")
    private String llaveApi;

    public String generarTokenJWT(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(llaveApi);
            return JWT.create()
                    .withIssuer("Foro Hub")
                    .withSubject(usuario.getNombreUsuario())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generateExpireDate(2))
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    private Instant generateExpireDate(int horas) {
        return LocalDateTime.now().plusHours(horas).toInstant(ZoneOffset.of("-05:00"));
    }

    public String getSubject(String token) {
        if (token == null) {
            throw new RuntimeException();
        }
        DecodedJWT verificador = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(llaveApi);

            verificador = JWT.require(algorithm)
                    .withIssuer("Foro Hub")
                    .build()
                    .verify(token);

        } catch (JWTVerificationException exception) {
            System.out.println(exception.toString());
        }

        if (verificador.getSubject() == null) {
            throw new RuntimeException("Verificador invalido");
        }
        return verificador.getSubject();
    }


}
