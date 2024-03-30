package br.com.fateb.InformaticaAPI.controller;

import br.com.fateb.InformaticaAPI.dto.request.ClienteRequest;
import br.com.fateb.InformaticaAPI.dto.request.ProdutoRequest;
import br.com.fateb.InformaticaAPI.entity.Cliente;
import br.com.fateb.InformaticaAPI.entity.Produto;
import br.com.fateb.InformaticaAPI.service.ClienteService;
import br.com.fateb.InformaticaAPI.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService service;

    @Autowired
    public void ClienteService(ProdutoService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna um Produto com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable("id") Integer id) {
        Produto produto = service.getProdutoById(id);
        return ResponseEntity.ok(produto);
    }

    @Operation(summary = "Retorna todos os Produtos")
    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos() {
        List<Produto> produtos = service.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    @Operation(summary = "Cadastra um Produto")
    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody ProdutoRequest request) {
        Produto produto = service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }
}