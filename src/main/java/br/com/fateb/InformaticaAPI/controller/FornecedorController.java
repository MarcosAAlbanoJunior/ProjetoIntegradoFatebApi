package br.com.fateb.InformaticaAPI.controller;

import br.com.fateb.InformaticaAPI.dto.request.FornecedorRequest;
import br.com.fateb.InformaticaAPI.entity.Fornecedor;
import br.com.fateb.InformaticaAPI.service.FornecedorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private FornecedorService service;

    @Autowired
    public void FornecedorService(FornecedorService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna um Fornecedor com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> getById(@PathVariable("id") Integer id) {
        Fornecedor venda = service.getFornecedorById(id);
        return ResponseEntity.ok(venda);
    }

    @Operation(summary = "Retorna todos os Fornecedors")
    @GetMapping
    public ResponseEntity<List<Fornecedor>> getFornecedors() {
        List<Fornecedor> vendas = service.getAllFornecedores();
        return ResponseEntity.ok(vendas);
    }

    @Operation(summary = "Cadastra um Fornecedor")
    @PostMapping
    public ResponseEntity<Fornecedor> cadastrarFornecedor(@RequestBody FornecedorRequest request) {
        Fornecedor venda = service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
    }
}
