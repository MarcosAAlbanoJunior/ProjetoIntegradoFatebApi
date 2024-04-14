package br.com.fateb.InformaticaAPI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "descricao_forma_pagamento", nullable = false, length = 100)
    private String descricaoFormaPagamento;

    @Column(name = "quantidade_parcelamento", nullable = false, length = 100)
    private String quantidadeParcelamento;

    @Column(name = "tipo_prazo", nullable = false)
    private Character tipoPrazo;

}