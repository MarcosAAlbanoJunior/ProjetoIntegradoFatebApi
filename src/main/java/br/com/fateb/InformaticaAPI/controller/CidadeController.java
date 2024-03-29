package br.com.fateb.InformaticaAPI.controller;

import br.com.fateb.InformaticaAPI.dto.request.CidadeRequest;
import br.com.fateb.InformaticaAPI.dto.request.ClienteRequest;
import br.com.fateb.InformaticaAPI.entity.Cidade;
import br.com.fateb.InformaticaAPI.entity.Cliente;
import br.com.fateb.InformaticaAPI.service.CidadeService;
import br.com.fateb.InformaticaAPI.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private CidadeService service;

    @Autowired
    public void CidadeService(CidadeService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna uma Cidade com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<Cidade> getByCpf(@PathVariable("id") Long id) {
        Cidade cliente = service.getCidadeById(id);
        return ResponseEntity.ok(cliente);
    }

    @Operation(summary = "Retorna todos os clientes")
    @GetMapping
    public ResponseEntity<List<Cidade>> getCidades() {
        List<Cidade> cidades = service.getAllCidades();
        return ResponseEntity.ok(cidades);
    }

    @Operation(summary = "Cadastra um Cliente")
    @PostMapping
    public ResponseEntity<Cidade> cadastrarCliente(@RequestBody Cidade request) {
        Cidade cidade = service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
    }

    @Operation(summary = "Atualiza uma Cidade")
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarCidade(@PathVariable Long id, @RequestBody CidadeRequest request) {
        service.atualizar(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
