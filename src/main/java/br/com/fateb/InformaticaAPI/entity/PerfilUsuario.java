package br.com.fateb.InformaticaAPI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "perfil_usuario")
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario", nullable = false)
    private Integer id;

    @Column(name = "tipo_usuario")
    private String tipoUsuario;

}