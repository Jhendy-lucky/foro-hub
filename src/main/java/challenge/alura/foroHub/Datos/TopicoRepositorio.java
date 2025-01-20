package challenge.alura.foroHub.Datos;

import challenge.alura.foroHub.Dominio.Topico;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepositorio extends JpaRepository<Topico,Integer> {

    Page<Topico> findByActivoTrue(Pageable pageable);
}
