package challenge.alura.foroHub.Presentacion.Controladores;

import challenge.alura.foroHub.Dominio.Topico;
import challenge.alura.foroHub.Negocios.Servicios.TopicoServicio;
import challenge.alura.foroHub.Presentacion.DTOs.Topico.TopicoActualizacionDTO;
import challenge.alura.foroHub.Presentacion.DTOs.Topico.TopicoDTOMapper;
import challenge.alura.foroHub.Presentacion.DTOs.Topico.TopicoLecturaDTO;
import challenge.alura.foroHub.Presentacion.DTOs.Topico.TopicoRegistroDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {

    @Autowired
    private final TopicoServicio topicoServicio;

    public TopicoController(TopicoServicio topicoServicio) {
        this.topicoServicio = topicoServicio;
    }

    @GetMapping
    public ResponseEntity<Page<TopicoLecturaDTO>> obtenerTopicos(@PageableDefault(size = 2) Pageable paginacion) {

        return ResponseEntity.ok(this.topicoServicio.obtenerTopicos(paginacion).map(TopicoLecturaDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoLecturaDTO> obtenerTopicoPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(TopicoDTOMapper.convertirTopicoATopicoLecturaDTO(this.topicoServicio.
                obtenetTopicoPorId(id)));
    }

    @PostMapping
    public ResponseEntity<TopicoLecturaDTO> registrarTopico(@RequestBody @Valid TopicoRegistroDTO topicoRegistroDTO,
                                                            UriComponentsBuilder uriComponentsBuilder){

        Topico topicoGuardado = this.topicoServicio.registrarTopico(TopicoDTOMapper.
                convertirTopicoRegistroDTOATopico(topicoRegistroDTO));

        URI urlNuevoTopico = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topicoGuardado.getId()).toUri();

        TopicoLecturaDTO topicoLecturaDTO = TopicoDTOMapper.convertirTopicoATopicoLecturaDTO(topicoGuardado);

        return ResponseEntity.created(urlNuevoTopico).body(topicoLecturaDTO);

    }

    @DeleteMapping("/fisicamente/{id}")
    public ResponseEntity<Boolean> eliminarFisicamente(@PathVariable Integer id){
        return ResponseEntity.ok(this.topicoServicio.eliminarFisicamente(id));
    }

    @DeleteMapping("/logicamente/{id}")
    public ResponseEntity<Boolean> eliminarLogicamente(@PathVariable Integer id){
        return ResponseEntity.ok(this.topicoServicio.eliminarLogicamente(id));
    }

    @PutMapping
    public ResponseEntity<Boolean> actualizar(@RequestBody @Valid TopicoActualizacionDTO topicoActualizacionDTO){

        Topico topico = TopicoDTOMapper.convertirTopicoActualizacionDTOATopico(topicoActualizacionDTO);

        return ResponseEntity.ok(this.topicoServicio.actualizar(topico));

    }
}
