package br.com.fateb.InformaticaAPI.dto.request;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link br.com.fateb.InformaticaAPI.entity.Cliente}
 */
@Value
public class ClienteRequest implements Serializable {
    String nomeCliente;
    String documento;
    String email;
    String endereco;
    Integer idCidade;
}