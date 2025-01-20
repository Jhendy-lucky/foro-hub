package challenge.alura.foroHub.Negocios.Interfaces;

import challenge.alura.foroHub.Dominio.Respuesta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRespuesta {

    public boolean registrarRespuesta(Respuesta respuesta);

    public Page<Respuesta> obtenerRespuestas(Pageable pageable);

}
