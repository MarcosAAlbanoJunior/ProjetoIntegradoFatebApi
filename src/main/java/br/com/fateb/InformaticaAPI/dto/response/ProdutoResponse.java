package br.com.fateb.InformaticaAPI.dto.response;

import io.swagger.models.auth.In;

import java.math.BigDecimal;

public record ProdutoResponse(Integer id, String nomeProduto, Integer quantidade, BigDecimal preco) {
}
