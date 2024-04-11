package br.com.fateb.InformaticaAPI.dto.request;

import java.io.Serializable;

/**
 * DTO for {@link br.com.fateb.InformaticaAPI.entity.Usuario}
 */

public record PerfilUsuarioRequest(String tipoUsuario) implements Serializable {
}