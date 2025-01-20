package challenge.alura.foroHub.Datos;

import challenge.alura.foroHub.Dominio.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepositorio extends JpaRepository<Respuesta, Integer> {
}
