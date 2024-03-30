package br.com.fateb.InformaticaAPI.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContasReceberResponse {
    private Integer id;

    private Integer idVenda;

    private ClienteResponse cliente;

    private UsuarioResponse usuario;

    private List<ProdutoResponse> produtosVenda;

    private BigDecimal valorTotal;

    private Instant dataVenda;

    private Instant dataVencimento;

    private String statusPagamento;


}
