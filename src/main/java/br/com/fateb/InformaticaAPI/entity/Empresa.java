package br.com.fateb.InformaticaAPI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "razaoSocial", nullable = false, length = 150)
    private String razaoSocial;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "ie", nullable = false, length = 150)
    private String ie;

    @Column(name = "email")
    private String email;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cidade", nullable = false)
    private Cidade idCidade;

    @Column(name = "endereco")
    private String endereco;

}