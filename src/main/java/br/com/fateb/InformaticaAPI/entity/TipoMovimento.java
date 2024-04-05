package br.com.fateb.InformaticaAPI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_movimento")
public class TipoMovimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_movimento", nullable = false)
    private Integer id;

    @Column(name = "descricao_movimento")
    private String descricaoMovimento;

}