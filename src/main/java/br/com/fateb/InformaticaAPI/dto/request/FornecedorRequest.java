package br.com.fateb.InformaticaAPI.dto.request;

import br.com.fateb.InformaticaAPI.entity.Fornecedor;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Fornecedor}
 */

public record FornecedorRequest(Integer id, String nomeFornecedor, String email, String endereco, String telefone,
                                String cnpj, String ie) implements Serializable {
}