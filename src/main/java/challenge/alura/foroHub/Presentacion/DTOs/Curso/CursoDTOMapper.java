package challenge.alura.foroHub.Presentacion.DTOs.Curso;

import challenge.alura.foroHub.Dominio.Curso;

import java.util.List;
import java.util.stream.Collectors;

public class CursoDTOMapper {

    public static Curso convertirCursoRegistroDTOACurso(CursoRegistroDTO cursoRegistroDTO){
        return new Curso(cursoRegistroDTO);
    }

    public static List<CursoLecturaDTO> convertirCursosACursosLecturaDTO(List<Curso> cursos){
        return cursos.stream()
                .map(CursoLecturaDTO::new)
                .collect(Collectors.toList());
    }
}
