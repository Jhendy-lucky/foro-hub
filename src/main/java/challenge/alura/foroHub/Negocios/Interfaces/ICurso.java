package challenge.alura.foroHub.Negocios.Interfaces;

import challenge.alura.foroHub.Dominio.Curso;

import java.util.List;

public interface ICurso {

    public boolean registrarCurso(Curso curso);

    public List<Curso> obtenerCursos();

}
