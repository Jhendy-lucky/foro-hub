package challenge.alura.foroHub.Presentacion.Controladores;

import challenge.alura.foroHub.Dominio.Usuario;
import challenge.alura.foroHub.Negocios.Servicios.UsuarioServicio;
import challenge.alura.foroHub.Presentacion.DTOs.Autenticacion.AutenticacionDTO;
import challenge.alura.foroHub.Presentacion.DTOs.Autenticacion.AutenticacionDTOMapper;
import challenge.alura.foroHub.Presentacion.DTOs.Autenticacion.JWTDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class AutenticacionController {

    @Autowired
    private final UsuarioServicio usuarioServicio;

    public AutenticacionController(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @PostMapping
    public ResponseEntity<JWTDTO> autenticateUser(@RequestBody @Valid AutenticacionDTO autenticacionDTO) {

        Usuario usuario = AutenticacionDTOMapper.convertirAutenticacionDTOAUsuario(autenticacionDTO);
        return ResponseEntity.ok(new JWTDTO(this.usuarioServicio.obtenerTokenJWT(usuario)));

    }

}
