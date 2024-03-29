package br.com.fateb.InformaticaAPI.entity;

import br.com.fateb.InformaticaAPI.entity.id.ProdutosVendaId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "produtos_vendas")
public class ProdutosVenda {
    @EmbeddedId
    private ProdutosVendaId id;

    @MapsId("idProduto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto idProduto;

    @MapsId("idVenda")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_venda", nullable = false)
    private Venda idVenda;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "preco_unitario", precision = 10, scale = 2)
    private BigDecimal precoUnitario;

}