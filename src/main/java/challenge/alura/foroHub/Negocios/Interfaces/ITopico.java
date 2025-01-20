package challenge.alura.foroHub.Negocios.Interfaces;

import challenge.alura.foroHub.Dominio.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITopico {

    public Page<Topico> obtenerTopicos(Pageable pageable);

    public Topico obtenetTopicoPorId(int id);

    public Topico registrarTopico(Topico topico);

    public boolean eliminarFisicamente(int id);

    public boolean eliminarLogicamente(int id);

    public boolean actualizar(Topico topico);
}
