package br.com.fateb.InformaticaAPI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido", nullable = false)
    private Integer id;

    @Column(name = "data_venda", nullable = false)
    private LocalDate dataVenda;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_vendedor", nullable = false)
    private Vendedor idVendedor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_forma_pagamento", nullable = false)
    private FormaPagamento idFormaPagamento;

    @Column(name = "quantidade_parcelas", nullable = false)
    private Integer quantidadeParcelas;

}