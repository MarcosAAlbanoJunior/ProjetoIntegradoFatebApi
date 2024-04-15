package br.com.fateb.InformaticaAPI.controller;

import br.com.fateb.InformaticaAPI.entity.MovimentoEstoque;
import br.com.fateb.InformaticaAPI.service.MovimentacaoEstoqueService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacao-estoque")
public class MovimentoEstoqueController {

    private MovimentacaoEstoqueService service;

    @Autowired
    public void MovimentoEstoqueService(MovimentacaoEstoqueService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna um MovimentoEstoque com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<MovimentoEstoque> getById(@PathVariable("id") Integer id) {
        MovimentoEstoque venda = service.getMovimentoEstoqueById(id);
        return ResponseEntity.ok(venda);
    }

    @Operation(summary = "Retorna todos os MovimentoEstoques")
    @GetMapping
    public ResponseEntity<List<MovimentoEstoque>> getMovimentoEstoques() {
        List<MovimentoEstoque> vendas = service.getAllMovimentoEstoques();
        return ResponseEntity.ok(vendas);
    }

}
