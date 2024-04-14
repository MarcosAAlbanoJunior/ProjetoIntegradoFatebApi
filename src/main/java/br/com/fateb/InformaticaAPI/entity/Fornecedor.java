package br.com.fateb.InformaticaAPI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor", nullable = false)
    private Integer id;

    @Column(name = "nome_fornecedor", nullable = false, length = 100)
    private String nomeFornecedor;

    @Column(name = "email",  nullable = false)
    private String email;

    @Column(name = "endereco",  nullable = false)
    private String endereco;

    @Column(name = "telefone",  nullable = false)
    private String telefone;

    @Column(name = "cnpj",  nullable = false)
    private String cnpj;

    @Column(name = "ie",  nullable = false)
    private String ie;

}

