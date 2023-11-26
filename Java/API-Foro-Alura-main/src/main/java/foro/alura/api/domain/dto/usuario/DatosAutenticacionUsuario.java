package foro.alura.api.domain.dto.usuario;

import jakarta.validation.constraints.Email;

public record DatosAutenticacionUsuario(@Email String email, String contraseña) {
}
