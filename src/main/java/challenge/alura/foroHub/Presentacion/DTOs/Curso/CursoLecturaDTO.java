package challenge.alura.foroHub.Presentacion.DTOs.Curso;

import challenge.alura.foroHub.Dominio.Curso;

public record CursoLecturaDTO(

        Integer id,

        String nombre,

        Integer cantidadEstudiantes
) {

    public CursoLecturaDTO(Curso curso){
        this(curso.getId(), curso.getNombre(), curso.getCantidadEstudiantes());
    }
}
