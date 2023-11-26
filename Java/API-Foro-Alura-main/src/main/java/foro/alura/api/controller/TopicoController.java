package foro.alura.api.controller;

import foro.alura.api.domain.dto.topico.DatosActualizarTopico;
import foro.alura.api.domain.dto.topico.DatosListadoTopico;
import foro.alura.api.domain.dto.topico.DatosRegistroTopico;
import foro.alura.api.domain.dto.topico.DatosRespuestaTopico;
import foro.alura.api.domain.model.Curso;
import foro.alura.api.domain.model.Topico;
import foro.alura.api.domain.model.Usuario;
import foro.alura.api.domain.repository.CursoRepository;
import foro.alura.api.domain.repository.TopicoRepository;
import foro.alura.api.domain.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private TopicoRepository topicoRepository;
    private UsuarioRepository usuarioRepository;
    private CursoRepository cursoRepository;
    @Autowired
    public TopicoController (TopicoRepository topicoRepository,
                             UsuarioRepository usuarioRepository,
                             CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> crearTopico(@RequestBody
                                                            @Valid
                                                            DatosRegistroTopico datosRegistroTopico,
                                                            UriComponentsBuilder uriComponentsBuilder) {
        Usuario autor = usuarioRepository.findByNombre(datosRegistroTopico.autor());
        Curso curso = cursoRepository.findByNombre(datosRegistroTopico.curso());

        Topico topico = topicoRepository.save(new Topico(
                datosRegistroTopico.titulo(),
                datosRegistroTopico.mensaje(),
                autor,
                curso
                ));

        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre());

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopico(@PageableDefault(size = 15) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.deshabilitarTopico(topico);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(
            @RequestBody
            @Valid
            DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatosTopico(datosActualizarTopico);

        return ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre());
        return  ResponseEntity.ok(datosTopico);
    }

}
