package br.com.fateb.InformaticaAPI.controller;

import br.com.fateb.InformaticaAPI.entity.FormaPagamento;
import br.com.fateb.InformaticaAPI.service.FormaPagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forma-pagamento")
public class FormaPagamentoController {

    private FormaPagamentoService service;

    @Autowired
    public void FormaPagamentoService(FormaPagamentoService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna um FormaPagamento com o iD informado")
    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamento> getById(@PathVariable("id") Integer id) {
        FormaPagamento formaPagamento = service.getFormaPagamentoById(id);
        return ResponseEntity.ok(formaPagamento);
    }

    @Operation(summary = "Retorna todos os FormaPagamentos")
    @GetMapping
    public ResponseEntity<List<FormaPagamento>> getFormaPagamentos() {
        List<FormaPagamento> formaPagamentos = service.getAllFormaPagamentos();
        return ResponseEntity.ok(formaPagamentos);
    }

    @Operation(summary = "Cadastra um FormaPagamento")
    @PostMapping
    public ResponseEntity<FormaPagamento> cadastrarFormaPagamento(@RequestBody FormaPagamento request) {
        FormaPagamento formaPagamento = service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(formaPagamento);
    }

    @Operation(summary = "Atualizar um FormaPagamento")
    @PutMapping
    public ResponseEntity<FormaPagamento> atualizarFormaPagamento(@RequestBody FormaPagamento request) {
        service.atualizarEntidade(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
