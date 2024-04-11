package br.com.fateb.InformaticaAPI.dto.response;

import java.math.BigDecimal;

public record ProdutosMaisVendidosResponse(Integer idProduto, String nomeProduto, Long quantidade, BigDecimal precoVendido) {
}
