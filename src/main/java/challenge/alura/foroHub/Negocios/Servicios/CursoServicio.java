package challenge.alura.foroHub.Negocios.Servicios;

import challenge.alura.foroHub.Datos.CursoRepositorio;
import challenge.alura.foroHub.Dominio.Curso;
import challenge.alura.foroHub.Negocios.Interfaces.ICurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServicio implements ICurso {

    @Autowired
    private final CursoRepositorio cursoRepositorio;

    public CursoServicio(CursoRepositorio cursoRepositorio) {
        this.cursoRepositorio = cursoRepositorio;
    }

    @Override
    public boolean registrarCurso(Curso curso) {
        try {
            this.cursoRepositorio.save(curso);
            return true;
        }catch (Exception e){
            System.out.println("Error: "+e);
            return false;
        }
    }

    @Override
    public List<Curso> obtenerCursos() {
        return this.cursoRepositorio.findAll();
    }
}
