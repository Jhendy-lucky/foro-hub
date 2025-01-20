package challenge.alura.foroHub.Negocios.Servicios;

import challenge.alura.foroHub.Datos.CursoRepositorio;
import challenge.alura.foroHub.Datos.TopicoRepositorio;
import challenge.alura.foroHub.Datos.UsuarioRepositorio;
import challenge.alura.foroHub.Dominio.Curso;
import challenge.alura.foroHub.Dominio.Topico;
import challenge.alura.foroHub.Dominio.Usuario;
import challenge.alura.foroHub.Infraestructura.Excepciones.ValidacionExcepcion;
import challenge.alura.foroHub.Negocios.Interfaces.ITopico;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class TopicoServicio implements ITopico {

    @Autowired
    private final TopicoRepositorio topicoRepositorio;

    @Autowired
    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private final CursoRepositorio cursoRepositorio;

    public TopicoServicio(TopicoRepositorio topicoRepositorio, UsuarioRepositorio usuarioRepositorio, CursoRepositorio cursoRepositorio) {
        this.topicoRepositorio = topicoRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
        this.cursoRepositorio = cursoRepositorio;
    }

    @Override
    public Page<Topico> obtenerTopicos(Pageable pageable) {
        return this.topicoRepositorio.findByActivoTrue(pageable);
    }

    @Override
    public Topico obtenetTopicoPorId(int id) {

        if (!this.topicoRepositorio.existsById(id)) {
            throw new ValidacionExcepcion("Topico no encontrado");
        }

         return this.topicoRepositorio.getReferenceById(id);
    }

    @Override
    public Topico registrarTopico(Topico topico) {

        if (!this.usuarioRepositorio.existsById(topico.getUsuario().getId())) {
            throw new ValidacionExcepcion("Usuario no encontrado");
        }

        if (!this.cursoRepositorio.existsById(topico.getCurso().getId())) {
            throw new ValidacionExcepcion("Curso no encontrado");
        }

        Curso curso = this.cursoRepositorio.getReferenceById(topico.getCurso().getId());
        Usuario usuario = this.usuarioRepositorio.getReferenceById(topico.getUsuario().getId());

        topico.setCurso(curso);
        topico.setUsuario(usuario);

        return this.topicoRepositorio.save(topico);

    }

    @Override
    public boolean eliminarFisicamente(int id) {

        if (!this.topicoRepositorio.existsById(id)) {
            throw new ValidacionExcepcion("Topico no encontrado");
        }
            this.topicoRepositorio.deleteById(id);
            return true;
    }

    @Override
    @Transactional
    public boolean eliminarLogicamente(int id) {

        if (!this.topicoRepositorio.existsById(id)) {
            throw new ValidacionExcepcion("Topico no encontrado");
        }

        Topico topico = this.topicoRepositorio.getReferenceById(id);
        topico.setActivo(false);
        return true;

    }

    @Override
    @Transactional
    public boolean actualizar(Topico nuevoTopico) {

        if (!this.topicoRepositorio.existsById(nuevoTopico.getId())) {
            throw new ValidacionExcepcion("Topico no encontrado");
        }

        Topico topicoAntiguo = this.topicoRepositorio.getReferenceById(nuevoTopico.getId());

        topicoAntiguo.setTitulo(nuevoTopico.getTitulo());
        topicoAntiguo.setMensaje(nuevoTopico.getMensaje());
        topicoAntiguo.setFecha(nuevoTopico.getFecha());

        return true;

    }
}
