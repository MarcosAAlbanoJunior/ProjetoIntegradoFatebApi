package br.com.fateb.InformaticaAPI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_movimento_estoque")
public class TipoMovimentoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_movimento", nullable = false)
    private Integer id;

    @Column(name = "descricao_movimento", nullable = false, length = 100)
    private String descricaoMovimento;

}