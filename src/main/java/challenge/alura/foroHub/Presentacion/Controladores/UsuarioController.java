package challenge.alura.foroHub.Presentacion.Controladores;

import challenge.alura.foroHub.Dominio.Usuario;
import challenge.alura.foroHub.Negocios.Servicios.UsuarioServicio;
import challenge.alura.foroHub.Presentacion.DTOs.Usuario.UsuarioLecturaDTO;
import challenge.alura.foroHub.Presentacion.DTOs.Usuario.UsuarioMapperDTO;
import challenge.alura.foroHub.Presentacion.DTOs.Usuario.UsuarioRegistroDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private final UsuarioServicio usuarioServicio;

    public UsuarioController(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @PostMapping
    public ResponseEntity<Boolean> registrarUsuario(@RequestBody @Valid UsuarioRegistroDTO usuarioRegistroDTO){

        Usuario usuario = UsuarioMapperDTO.convertirUsuarioRegistroDTOAUsuario(usuarioRegistroDTO);

        return ResponseEntity.ok(this.usuarioServicio.registrarUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioLecturaDTO>> obtenerUsuarios(){
        return ResponseEntity.ok(UsuarioMapperDTO.convertirUsuariosAUsuariosLecturaDTO(this.usuarioServicio.obtenerUsuarios()));
    }
}
