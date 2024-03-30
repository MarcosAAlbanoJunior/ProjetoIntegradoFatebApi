package br.com.fateb.InformaticaAPI.dto.response;

public record UsuarioResponse(Integer idUsuario, String nomeUsuario, String cpfUsuario, String email, Integer idEmpresa) {
}
