package challenge.alura.foroHub.Presentacion.Controladores;

import challenge.alura.foroHub.Dominio.Curso;
import challenge.alura.foroHub.Negocios.Servicios.CursoServicio;
import challenge.alura.foroHub.Presentacion.DTOs.Curso.CursoDTOMapper;
import challenge.alura.foroHub.Presentacion.DTOs.Curso.CursoLecturaDTO;
import challenge.alura.foroHub.Presentacion.DTOs.Curso.CursoRegistroDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private final CursoServicio cursoServicio;

    public CursoController(CursoServicio cursoServicio) {
        this.cursoServicio = cursoServicio;
    }

    @PostMapping
    public ResponseEntity<Boolean> registrarCurso(@RequestBody @Valid CursoRegistroDTO cursoRegistroDTO){

        Curso curso = CursoDTOMapper.convertirCursoRegistroDTOACurso(cursoRegistroDTO);

        return ResponseEntity.ok().body(this.cursoServicio.registrarCurso(curso));
    }

    @GetMapping
    public ResponseEntity<List<CursoLecturaDTO>> obtenerCursos(){
        return  ResponseEntity.ok(CursoDTOMapper.convertirCursosACursosLecturaDTO(this.cursoServicio.
                obtenerCursos()));
    }
}
