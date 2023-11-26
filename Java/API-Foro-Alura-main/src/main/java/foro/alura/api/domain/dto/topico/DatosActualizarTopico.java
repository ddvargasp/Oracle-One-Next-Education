package foro.alura.api.domain.dto.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Long id, String titulo, String mensaje, String autor, String curso) {
}
