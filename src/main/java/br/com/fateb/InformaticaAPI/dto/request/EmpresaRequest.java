package br.com.fateb.InformaticaAPI.dto.request;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link br.com.fateb.InformaticaAPI.entity.Empresa}
 */
@Value
public class EmpresaRequest implements Serializable {
    String razaoSocial;
    String cnpj;
    String ie;
    String email;
    String nomeFantasia;
    String endereco;
}