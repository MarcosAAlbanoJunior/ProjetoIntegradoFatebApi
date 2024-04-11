package br.com.fateb.InformaticaAPI.dto.response;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

public record ComissaoResponse(Integer idUsuario, String nomeUsuario, BigDecimal comissaoTotal) {
}
