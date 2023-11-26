package foro.alura.api.domain.dto.usuario;

import foro.alura.api.domain.model.Usuario;

public record DatosListadoUsuario(Long id, String nombre, String email) {
    public DatosListadoUsuario(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail());
    }
}
