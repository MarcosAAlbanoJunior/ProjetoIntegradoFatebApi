package br.com.fateb.InformaticaAPI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "produto_pedido")
public class ProdutoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido idPedido;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto idProduto;

    @Column(name = "valor_produto_real", nullable = false)
    private BigDecimal valorProdutoReal;

    @Column(name = "valor_produto_desconto")
    private BigDecimal valorProdutoDesconto;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

}