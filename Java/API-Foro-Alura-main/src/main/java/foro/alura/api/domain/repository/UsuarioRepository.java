package foro.alura.api.domain.repository;

import foro.alura.api.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {
    Usuario findByNombre(String nombre);

    UserDetails findByEmail(String email);
    //UserDetails findByEmail(String email);
}
