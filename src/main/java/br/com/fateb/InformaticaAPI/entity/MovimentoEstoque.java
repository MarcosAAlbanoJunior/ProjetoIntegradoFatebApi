package br.com.fateb.InformaticaAPI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "movimento_estoque")
public class MovimentoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto idProduto;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_tipo_movimento", nullable = false)
    private TipoMovimentoEstoque idTipoMovimento;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "data_movimento", nullable = false)
    private LocalDate dataMovimento;

}