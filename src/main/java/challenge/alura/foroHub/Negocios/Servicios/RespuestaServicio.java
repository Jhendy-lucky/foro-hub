package challenge.alura.foroHub.Negocios.Servicios;

import challenge.alura.foroHub.Datos.RespuestaRepositorio;
import challenge.alura.foroHub.Datos.TopicoRepositorio;
import challenge.alura.foroHub.Datos.UsuarioRepositorio;
import challenge.alura.foroHub.Dominio.Respuesta;
import challenge.alura.foroHub.Dominio.Topico;
import challenge.alura.foroHub.Dominio.Usuario;
import challenge.alura.foroHub.Infraestructura.Excepciones.ValidacionExcepcion;
import challenge.alura.foroHub.Negocios.Interfaces.IRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class RespuestaServicio implements IRespuesta {

    @Autowired
    private final RespuestaRepositorio respuestaRepositorio;

    @Autowired
    private final TopicoRepositorio topicoRepositorio;

    @Autowired
    private final UsuarioRepositorio usuarioRepositorio;

    public RespuestaServicio(RespuestaRepositorio respuestaRepositorio, TopicoRepositorio topicoRepositorio, UsuarioRepositorio usuarioRepositorio) {
        this.respuestaRepositorio = respuestaRepositorio;
        this.topicoRepositorio = topicoRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public boolean registrarRespuesta(Respuesta respuesta) {

        if(!this.usuarioRepositorio.existsById(respuesta.getUsuario().getId())){
            throw new ValidacionExcepcion("Usuario no encontrado");
        }

        if(!this.topicoRepositorio.existsById(respuesta.getTopico().getId())){
            throw new ValidacionExcepcion("Topico no encontrado");
        }

        Topico topico = this.topicoRepositorio.getReferenceById(respuesta.getTopico().getId());

        Usuario usuario = this.usuarioRepositorio.getReferenceById(respuesta.getUsuario().getId());

        respuesta.setUsuario(usuario);
        respuesta.setTopico(topico);

        this.respuestaRepositorio.save(respuesta);
        return true;
    }

    @Override
    public Page<Respuesta> obtenerRespuestas(Pageable pageable) {
        return this.respuestaRepositorio.findAll(pageable);
    }
}
