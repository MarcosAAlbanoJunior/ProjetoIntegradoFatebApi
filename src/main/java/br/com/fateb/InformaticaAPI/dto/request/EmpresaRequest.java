package br.com.fateb.InformaticaAPI.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link br.com.fateb.InformaticaAPI.entity.Empresa}
 */

public record EmpresaRequest(String razaoSocial, String cnpj, String ie, String email, String nomeFantasia,
                             String endereco) implements Serializable {
}