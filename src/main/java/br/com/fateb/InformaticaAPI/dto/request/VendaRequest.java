package br.com.fateb.InformaticaAPI.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link br.com.fateb.InformaticaAPI.entity.Venda}
 */

public record VendaRequest(Integer idCliente, Integer idUsuario,
                           List<ProdutoVendaRequest> produtosVenda, String tipoPagamento, Integer parcelas) implements Serializable {

}