package foro.alura.api.domain.dto.topico;

import foro.alura.api.domain.model.Topico;

public record DatosListadoTopico(Long id, String titulo, String mensaje,
                                 String fecha_creacion, String estatus_topico,
                                 String autor, String curso) {

    public DatosListadoTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion().toString(),
                topico.getStatus().toString(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre());
    }
}
