package br.com.fateb.InformaticaAPI.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;


public record ProdutoVendaIdRequest(Integer idProduto, Integer idVenda) implements Serializable  {

}
