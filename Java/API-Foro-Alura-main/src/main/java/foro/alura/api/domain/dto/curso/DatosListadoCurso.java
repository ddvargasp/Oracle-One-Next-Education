package foro.alura.api.domain.dto.curso;

import foro.alura.api.domain.model.Curso;

public record DatosListadoCurso(Long id, String nombre, String categoria) {
    public DatosListadoCurso(Curso curso){
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
