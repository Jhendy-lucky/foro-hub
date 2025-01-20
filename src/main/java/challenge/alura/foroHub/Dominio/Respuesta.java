package challenge.alura.foroHub.Dominio;

import challenge.alura.foroHub.Presentacion.DTOs.Respuesta.RespuestaRegistroDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String comentario;

    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    public Respuesta(RespuestaRegistroDTO respuestaRegistroDTO){
        this.comentario = respuestaRegistroDTO.comentario();
        this.fecha = respuestaRegistroDTO.fecha();
        this.usuario = new Usuario(respuestaRegistroDTO.usuario_id());
        this.topico = new Topico(respuestaRegistroDTO.topico_id());
    }
}
