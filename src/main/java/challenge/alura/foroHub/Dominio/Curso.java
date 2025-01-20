package challenge.alura.foroHub.Dominio;

import challenge.alura.foroHub.Presentacion.DTOs.Curso.CursoRegistroDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @JsonAlias("cantidad_estudiantes")
    private Integer cantidadEstudiantes;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Topico> topicos;

    public Curso(CursoRegistroDTO cursoRegistroDTO){
        this.nombre = cursoRegistroDTO.nombre();
        this.cantidadEstudiantes = cursoRegistroDTO.cantidadEstudiantes();
    }

    public Curso(@NotNull @Min(1) Integer id) {
        this.id = id;
    }
}
