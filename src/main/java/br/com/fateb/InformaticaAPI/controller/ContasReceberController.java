package br.com.fateb.InformaticaAPI.controller;


import br.com.fateb.InformaticaAPI.dto.request.ComissaoRequest;
import br.com.fateb.InformaticaAPI.dto.response.ComissaoResponse;
import br.com.fateb.InformaticaAPI.dto.response.ContasReceberResponse;
import br.com.fateb.InformaticaAPI.entity.ContasReceber;
import br.com.fateb.InformaticaAPI.entity.ContasReceberParcela;
import br.com.fateb.InformaticaAPI.service.ContasReceberParcelaService;
import br.com.fateb.InformaticaAPI.service.ContasReceberService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas-receber")
public class ContasReceberController {

    private ContasReceberService service;

    private ContasReceberParcelaService contasReceberParcelaService;

    @Autowired
    public void ContasReceberService(ContasReceberService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna um ContasReceber com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<ContasReceber> getByCpf(@PathVariable("id") Integer id) {
        ContasReceber contasReceber = service.getContasReceberById(id);
        return ResponseEntity.ok(contasReceber);
    }

    @Operation(summary = "Retorna todos os contasRecebers")
    @GetMapping
    public ResponseEntity<List<ContasReceber>> getContasReceber() {
        List<ContasReceber> contasReceber = service.getAllContasReceber();
        return ResponseEntity.ok(contasReceber);
    }

    @Operation(summary = "Retorna todas parcelas de contasRecebers")
    @GetMapping("/parcelas/{idPedido}")
    public ResponseEntity<List<ContasReceberParcela>> getContasReceber(@PathVariable("idPedido") Integer id) {
        List<ContasReceberParcela> contasReceberParcelas = contasReceberParcelaService.getAllContasReceberParcelaByPedido(id);
        return ResponseEntity.ok(contasReceberParcelas);
    }

    @Operation(summary = "Retorna tadas as comissões do usuarios")
    @GetMapping("/comissoes")
    public ResponseEntity<List<ComissaoResponse>> getUsuario(@RequestBody ComissaoRequest request) {
        List<ComissaoResponse> comissoes = service.buscarComissoesData(request.data());
        return ResponseEntity.ok(comissoes);
    }

}
