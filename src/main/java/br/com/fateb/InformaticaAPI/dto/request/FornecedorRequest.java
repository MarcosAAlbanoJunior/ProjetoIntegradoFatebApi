package br.com.fateb.InformaticaAPI.dto.request;

import java.io.Serializable;

/**
 * DTO for {@link Fornecedor}
 */

public record FornecedorRequest(Integer id, String nomeFornecedor, String email, String endereco, String telefone,
                                String cnpj, String ie) implements Serializable {
}