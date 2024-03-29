package br.com.fateb.InformaticaAPI.dto.request;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link br.com.fateb.InformaticaAPI.entity.Cidade}
 */
@Value
public class CidadeRequest implements Serializable {
    Integer id;
    String nomeCidade;
}