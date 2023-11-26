package foro.alura.api.domain.model;

import foro.alura.api.domain.dto.topico.DatosActualizarTopico;
import foro.alura.api.domain.dto.topico.DatosRegistroTopico;
import foro.alura.api.domain.enumerated.StatusTopico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String titulo;

    @NotBlank
    @Column(nullable = false)
    private String mensaje;

    @NotNull
    @CreatedDate
    //Indica la fecha de creacion del topico. Consultar en: https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/annotation/CreatedDate.html
    @Column(nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NO_RESPONDIDO;

    @NotNull
    @ManyToOne
    private Usuario autor;

    @NotNull
    @ManyToOne
    private Curso curso;

    private Boolean activo;

    @NotNull
    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas = new ArrayList<>();

    public Topico(DatosRegistroTopico datosRegistroTopico, Usuario autor, Curso curso)  {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.autor = autor;
        this.curso = curso;
        this.activo = true;
    }

    public Topico(String titulo, String mensaje, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor =  autor;
        this.curso = curso;
    }

    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDateTime.now();
    }

    public void deshabilitarTopico(Topico topico) {
        this.activo = false;
    }


    public void actualizarDatosTopico(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo  = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje()  != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
    }
}
