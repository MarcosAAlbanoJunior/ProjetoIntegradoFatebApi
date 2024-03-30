package br.com.fateb.InformaticaAPI.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.math.BigDecimal;


public record ProdutoVendaRequest(Integer idProduto, Integer quantidade) {

}
