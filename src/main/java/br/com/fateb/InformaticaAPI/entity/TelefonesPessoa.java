package br.com.fateb.InformaticaAPI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "telefones_pessoas")
public class TelefonesPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone", nullable = false)
    private Integer id;

    @Column(name = "numero_telefone")
    private String numeroTelefone;

    @Column(name = "tipo_pessoa")
    private String tipoPessoa;

    @Column(name = "id_pessoa")
    private Integer idPessoa;

}