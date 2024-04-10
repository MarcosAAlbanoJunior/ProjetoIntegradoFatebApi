package br.com.fateb.InformaticaAPI.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link br.com.fateb.InformaticaAPI.entity.Produto}
 */

public record TelefoneRequest(Integer idPessoa, String tipoPessoa, String numeroTelefone) implements Serializable {
}