package br.com.fateb.InformaticaAPI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "contas_receber")
public class ContasReceber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_venda")
    private Venda idVenda;

    @Column(name = "valor_total", precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "valor_parcela", precision = 10, scale = 2)
    private BigDecimal valorParcela;


    @Column(name = "data_vencimento")
    private Instant dataVencimento;

    @Column(name = "status_pagamento")
    private String statusPagamento;

    @Column(name = "comissao_venda")
    private BigDecimal comissaoVenda;

}