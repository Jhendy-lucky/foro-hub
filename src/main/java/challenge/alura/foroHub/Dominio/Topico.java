package challenge.alura.foroHub.Dominio;

import challenge.alura.foroHub.Presentacion.DTOs.Topico.TopicoActualizacionDTO;
import challenge.alura.foroHub.Presentacion.DTOs.Topico.TopicoRegistroDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    private String mensaje;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private boolean activo;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuestas;


    public Topico(TopicoRegistroDTO topicoRegistroDTO) {
        this.titulo = topicoRegistroDTO.titulo();
        this.mensaje = topicoRegistroDTO.mensaje();
        this.fecha = topicoRegistroDTO.fecha();
        this.usuario = new Usuario(topicoRegistroDTO.usuario_id());
        this.curso = new Curso(topicoRegistroDTO.curso_id());
        this.activo = true;
    }

    public Topico(TopicoActualizacionDTO topicoActualizacionDTO) {
        this.id = topicoActualizacionDTO.id();
        this.titulo = topicoActualizacionDTO.titulo();
        this.mensaje = topicoActualizacionDTO.mensaje();
        this.fecha = topicoActualizacionDTO.fecha();
    }

    public Topico(int id) {
        this.id = id;
    }
}
