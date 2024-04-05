package br.com.fateb.InformaticaAPI.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class VendaResponse {

    private Integer id;
    private Instant dataVenda;
    private ClienteResponse cliente;
    private UsuarioResponse usuario;
    private Integer idContasReceber;
}
