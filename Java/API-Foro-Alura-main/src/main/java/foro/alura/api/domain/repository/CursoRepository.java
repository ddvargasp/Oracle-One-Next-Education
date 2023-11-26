package foro.alura.api.domain.repository;

import foro.alura.api.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNombre(String curso);
}
