package br.com.fateb.InformaticaAPI.controller;

import br.com.fateb.InformaticaAPI.entity.Estoque;
import br.com.fateb.InformaticaAPI.service.EstoqueService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private EstoqueService service;

    @Autowired
    public void EstoqueService(EstoqueService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna uma Estoque com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<Estoque> getById(@PathVariable("id") Integer id) {
        Estoque estoque = service.getEstoqueById(id);
        return ResponseEntity.ok(estoque);
    }

    @Operation(summary = "Retorna todos as Estoques")
    @GetMapping
    public ResponseEntity<List<Estoque>> getEstoques() {
        List<Estoque> estoque = service.getAllEstoques();
        return ResponseEntity.ok(estoque);
    }

    @Operation(summary = "Cadastra um Estoque")
    @PostMapping
    public ResponseEntity<Estoque> cadastrarEstoque(@RequestBody Estoque request) {
        Estoque estoque = service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(estoque);
    }

    @Operation(summary = "Atualizar um Estoque")
    @PutMapping
    public ResponseEntity<Estoque> atualizarEstoque(@RequestBody Estoque request) {
        Estoque estoque = service.atualizarEestoque(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(estoque);
    }
}
