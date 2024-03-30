package br.com.fateb.InformaticaAPI.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link br.com.fateb.InformaticaAPI.entity.Usuario}
 */

public record UsuarioRequest(String nomeUsuario, String cpfUsuario, String telefone, String email, String endereco,
                             Integer idEmpresa) implements Serializable {
}