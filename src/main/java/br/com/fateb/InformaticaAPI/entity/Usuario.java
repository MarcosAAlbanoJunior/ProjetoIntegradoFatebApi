package br.com.fateb.InformaticaAPI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "login", nullable = false, length = 100)
    private String login;

    @Column(name = "senha", nullable = false, length = 100)
    private String senha;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_perfil_usuario", nullable = false)
    private PerfilUsuario idPerfilUsuario;

}