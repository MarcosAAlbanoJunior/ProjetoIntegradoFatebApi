package br.com.fateb.InformaticaAPI.dto.request;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link br.com.fateb.InformaticaAPI.entity.Categoria}
 */
@Value
public class CategoriaRequest implements Serializable {
    Integer id;
    String nomeCategoria;
}