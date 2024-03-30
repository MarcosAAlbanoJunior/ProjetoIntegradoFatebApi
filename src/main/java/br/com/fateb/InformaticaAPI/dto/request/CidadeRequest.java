package br.com.fateb.InformaticaAPI.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link br.com.fateb.InformaticaAPI.entity.Cidade}
 */

public record CidadeRequest(Integer id, String nomeCidade) implements Serializable {
}