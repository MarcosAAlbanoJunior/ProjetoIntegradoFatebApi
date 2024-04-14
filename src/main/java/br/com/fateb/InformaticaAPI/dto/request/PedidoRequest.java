package br.com.fateb.InformaticaAPI.dto.request;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link br.com.fateb.InformaticaAPI.entity.Pedido}
 */

public record PedidoRequest(Integer idCliente, Integer idVendedor,
                            List<ProdutoPedidoRequest> produtosPedido, Integer idFormaPagamento, Integer quantidadeParcelas) implements Serializable {

}