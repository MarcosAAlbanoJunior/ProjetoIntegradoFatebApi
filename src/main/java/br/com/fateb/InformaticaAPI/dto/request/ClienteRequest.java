package br.com.fateb.InformaticaAPI.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link br.com.fateb.InformaticaAPI.entity.Cliente}
 */

public record ClienteRequest(String nomeCliente, String documento, String email, String endereco,
                             Integer idCidade) implements Serializable {
}