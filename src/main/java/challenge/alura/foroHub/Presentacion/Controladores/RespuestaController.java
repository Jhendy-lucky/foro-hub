package challenge.alura.foroHub.Presentacion.Controladores;

import challenge.alura.foroHub.Dominio.Respuesta;
import challenge.alura.foroHub.Negocios.Servicios.RespuestaServicio;
import challenge.alura.foroHub.Presentacion.DTOs.Respuesta.RespuestaLecturaDTO;
import challenge.alura.foroHub.Presentacion.DTOs.Respuesta.RespuestaMapperDTO;
import challenge.alura.foroHub.Presentacion.DTOs.Respuesta.RespuestaRegistroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    @Autowired
    private final RespuestaServicio respuestaServicio;

    public RespuestaController(RespuestaServicio respuestaServicio) {
        this.respuestaServicio = respuestaServicio;
    }

    @GetMapping
    public ResponseEntity<Page<RespuestaLecturaDTO>> obtenerRespuestas( @PageableDefault(size = 2) Pageable pageable){
        return ResponseEntity.ok(RespuestaMapperDTO.convertirRespuestasARespuestasLecturaDTO(this.respuestaServicio
                .obtenerRespuestas(pageable)));
    }

    @PostMapping
    public ResponseEntity<Boolean> registrarRespuesta(@RequestBody RespuestaRegistroDTO respuestaRegistroDTO){

        Respuesta respuesta = RespuestaMapperDTO.convertirRepuestaRegistroDTOARegistro(respuestaRegistroDTO);

        return ResponseEntity.ok(this.respuestaServicio.registrarRespuesta(respuesta));
    }
}
