package br.com.fateb.InformaticaAPI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "movimento_estoque")
public class MovimentoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimento", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_movimento")
    private TipoMovimento tipoMovimento;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "data_movimento")
    private Instant dataMovimento;

}