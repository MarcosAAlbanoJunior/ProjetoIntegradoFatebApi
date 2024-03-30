package br.com.fateb.InformaticaAPI.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link br.com.fateb.InformaticaAPI.entity.Produto}
 */

public record ProdutoRequest(String nomeProduto, BigDecimal preco, Integer quantidadeEstoque, Integer idCategoria,
                             Integer idFornecedor) implements Serializable {
}