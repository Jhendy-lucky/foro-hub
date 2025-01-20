package challenge.alura.foroHub.Datos;

import challenge.alura.foroHub.Dominio.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepositorio extends JpaRepository<Curso, Integer> {
}
