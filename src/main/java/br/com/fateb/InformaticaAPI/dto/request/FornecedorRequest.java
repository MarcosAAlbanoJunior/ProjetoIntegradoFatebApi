package br.com.fateb.InformaticaAPI.dto.request;

import br.com.fateb.InformaticaAPI.entity.Fornecedor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Fornecedor}
 */
@Value
public class FornecedorRequest implements Serializable {
    Integer id;
    String nomeFornecedor;
    String email;
    String endereco;
    String telefone;
    String cnpj;
    String ie;
}