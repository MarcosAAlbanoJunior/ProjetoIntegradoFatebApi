package br.com.fateb.InformaticaAPI.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link br.com.fateb.InformaticaAPI.entity.Categoria}
 */

public record CategoriaRequest(Integer id, String nomeCategoria) implements Serializable {
}