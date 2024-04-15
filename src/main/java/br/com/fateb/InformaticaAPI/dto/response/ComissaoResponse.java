package br.com.fateb.InformaticaAPI.dto.response;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

public record ComissaoResponse(Integer idVendedor, String nomeVendedor, BigDecimal comissaoTotal) {

}